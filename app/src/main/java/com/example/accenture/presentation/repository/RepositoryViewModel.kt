package com.example.accenture.presentation.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.accenture.data.GithubRepository
import com.example.accenture.presentation.repository.RepositoryUiState.*
import com.example.accenture.presentation.repository.mapper.RepositoryMapper
import com.example.accenture.presentation.repository.model.Repository
import com.example.accenture.presentation.repository.model.RepositoryItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class RepositoryViewModel(
    private val repository: GithubRepository,
    private val mapper: RepositoryMapper
    ): ViewModel() {

    private val _uiState = MutableStateFlow<RepositoryUiState>(Empty)
    val uiState: StateFlow<RepositoryUiState> = _uiState



    init {
        fetchRepository()
    }

   fun fetchRepository(){
        viewModelScope.launch {
            repository.getRepository()
                .flowOn(Dispatchers.Default)
                .onStart {
                    _uiState.value = Loading
                }
                .catch { e->
                    _uiState.value = Error(e)
                }
                .collect { repository ->
                    val mapRepository = with(mapper) { repository.toPresentation() }
                    _uiState.value = Success(mapRepository.repositoryItems)
                }
        }

    }
}