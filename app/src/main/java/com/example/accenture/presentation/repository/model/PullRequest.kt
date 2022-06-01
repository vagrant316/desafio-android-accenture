package com.example.accenture.presentation.repository.model

import com.example.accenture.data.remote.model.RemotePullRequest

data class PullRequest(
    val repositoryItems: List<PullRequestItem>
)
