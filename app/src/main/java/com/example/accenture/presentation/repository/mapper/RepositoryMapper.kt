package com.example.accenture.presentation.repository.mapper

import com.example.accenture.data.remote.model.RemoteOwner
import com.example.accenture.data.remote.model.RemoteRepository
import com.example.accenture.data.remote.model.RemoteRepositoryItem
import com.example.accenture.presentation.repository.model.Owner
import com.example.accenture.presentation.repository.model.Repository
import com.example.accenture.presentation.repository.model.RepositoryItem

class RepositoryMapper() {

    fun RemoteRepository.toPresentation() = Repository(
        repositoryItems = repositoryItems?.map { repository ->
            repository.toPresentation()} ?: listOf()
    )

    private fun RemoteRepositoryItem.toPresentation() = RepositoryItem(
        id = id.orEmpty(),
        name = name.orEmpty(),
        description = description.orEmpty(),
        owner = remoteOwner?.toPresentation()?: Owner(
            "",
            ""
        ),
        stargazerCount =  stargazerCount ?: 0,
        forkCount =  forkCount ?: 0
    )
    fun RemoteOwner.toPresentation() = Owner(
        login = login.orEmpty(),
        avatarUrl = avatarUrl.orEmpty()

    )
}