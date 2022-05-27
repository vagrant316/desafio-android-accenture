package com.example.accenture.presentation.repository.model


data class RepositoryItem(
    val id: String,
    val name: String,
    val description: String,
    val owner: Owner,
    val stargazerCount: Int,
    val forkCount: Int
)
