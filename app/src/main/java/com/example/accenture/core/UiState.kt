package com.example.accenture.core


sealed class UiState{
    object Success : UiState()
    object Empty : UiState()
    object Loading : UiState()
    class Error(val exception: Throwable): UiState()
}
