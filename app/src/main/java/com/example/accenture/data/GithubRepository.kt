package com.example.accenture.data

import com.example.accenture.data.source.GitHubRemote
import kotlinx.coroutines.flow.flow

class GithubRepository(
    private val remote: GitHubRemote
) {

    fun getRepository() = flow {
        val repository = remote.getRepository()
        emit(repository)
    }

    fun getPullRequest(creator: String, repo: String) = flow  {
        emit(remote.getPullRequest(creator, repo))
    }

}