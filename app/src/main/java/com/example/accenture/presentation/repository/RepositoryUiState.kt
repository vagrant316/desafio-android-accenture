package com.example.accenture.presentation.repository

import com.example.accenture.presentation.repository.model.RepositoryItem

sealed class RepositoryUiState{
    data class Success(val repositoryItem: List<RepositoryItem>): RepositoryUiState()
    object Empty : RepositoryUiState()

    object Loading : RepositoryUiState()
    data class Error(val exception: Throwable): RepositoryUiState()

}
