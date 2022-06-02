package com.example.accenture.core

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.transform


sealed class UiState<T>{
    data class Success<T>(val resource: T): UiState<T>()
    class Empty<T> : UiState<T>()
    class Loading<T> : UiState<T>()
    class Error<T>(val exception: Throwable): UiState<T>()



    suspend inline fun <R : Any> suspendMap(crossinline transform: suspend (T) -> R): StatefulData<R> {
        return when(this) {
            is Empty -> StatefulData.Empty()
            is Loading -> StatefulData.Loading
            is Error -> StatefulData.Error(this.exception.message.toString())
            is Success -> StatefulData.Success(transform(this.resource))
        }
    }
}


sealed class StatefulData<out T> {
    data class Success<T>(val result : T) : StatefulData<T>()
    data class Error(val msg : String) : StatefulData<Nothing>()
    object Loading : StatefulData<Nothing>()
    class Empty<T> : StatefulData<T>()

    inline fun <R : Any> map(transform: (T) -> R): StatefulData<R> {
        return when(this) {
            is Loading -> Loading
            is Error -> Error(this.msg)
            is Success -> Success(transform(this.result))
            is Empty -> Empty()
        }
    }

    suspend inline fun <R : Any> suspendMap(crossinline transform: suspend (T) -> R): StatefulData<R> {
        return when(this) {
            is Loading -> Loading
            is Error -> Error(this.msg)
            is Success -> Success(transform(this.result))
            is Empty -> Empty()
        }
    }
}

fun <T:Any> Flow<T>.asStatefulData(): Flow<StatefulData<T>> = wrapWithStatefulData()
    .catch {
        emit(StatefulData.Error(it.message ?: "There was an error"))
    }

fun <T:Any> Flow<T>.wrapWithStatefulData() : Flow<StatefulData<T>> = transform { value ->
    return@transform emit(StatefulData.Success(value))
}

inline fun <T:Any,R:Any> Flow<StatefulData<T>>.mapState(crossinline transform: suspend (value: T) -> R): Flow<StatefulData<R>> = transform { value ->
    return@transform emit(value.suspendMap(transform))
}

inline fun <T> Flow<StatefulData<T>>.onSuccessState(crossinline action: suspend (value: T) -> Unit): Flow<StatefulData<T>> = onEach {
    if (it is StatefulData.Success) action(it.result)
}

inline fun <T:Any> Flow<StatefulData<T>>.onErrorState(crossinline action: suspend (error: String) -> Unit): Flow<StatefulData<T>> = onEach {
    if (it is StatefulData.Error) action(it.msg)
}

inline fun <T:Any> Flow<StatefulData<T>>.onLoadingState(crossinline action: suspend (error: String) -> Unit): Flow<StatefulData<T>> = onEach {
    if (it is StatefulData.Error) action(it.msg)
}