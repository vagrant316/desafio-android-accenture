package com.example.accenture.data.remote

import com.example.accenture.data.remote.model.RemotePullRequest
import com.example.accenture.data.remote.model.RemoteRepository
import com.example.accenture.data.remote.retrofit.GitHubWebService
import com.example.accenture.data.source.GitHubRemote

class GitHubRemoteImpl(
    private val webService: GitHubWebService
    ) : GitHubRemote {

    override suspend fun getRepository(
    ): RemoteRepository = webService.getRepository(1)

    override suspend fun getPullRequest(creator: String, repo: String): List<RemotePullRequest> =
        webService.getPullRequest(creator, repo)
}