package com.example.accenture.presentation.repository.mapper


import com.example.accenture.data.remote.model.RemotePullRequest
import com.example.accenture.data.remote.model.RemoteUser
import com.example.accenture.presentation.repository.model.*

fun List<RemotePullRequest>.toPresentation() = map {
    PullRequestItem(
        title = it.title ?: "",
        body = it.body ?: "",
        user = it.remoteUser?.toPresentation() ?: User(
            "",
            ""
        )
    )
}

fun RemoteUser.toPresentation() = User(
    login = login.orEmpty(),
    avatar_url = avatar_url.orEmpty()

)

