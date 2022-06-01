package com.example.accenture.data.source

import com.example.accenture.data.remote.model.RemotePullRequest
import com.example.accenture.data.remote.model.RemoteRepository

interface GitHubRemote {

    suspend fun getRepository(): RemoteRepository
    suspend fun getPullRequest(creator: String, repo: String): List<RemotePullRequest>
}