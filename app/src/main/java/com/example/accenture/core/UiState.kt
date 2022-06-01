package com.example.accenture.core


sealed class UiState<T>{
    data class Success<T>(val resource: T): UiState<T>()
    class Empty<T> : UiState<T>()
    class Loading<T> : UiState<T>()
    class Error<T>(val exception: Throwable): UiState<T>()
}
