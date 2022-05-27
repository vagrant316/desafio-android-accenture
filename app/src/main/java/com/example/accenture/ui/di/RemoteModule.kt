package com.example.accenture.ui.di

import com.example.accenture.data.GithubRepository
import com.example.accenture.data.remote.GitHubRemoteImpl
import com.example.accenture.data.source.GitHubRemote
import com.example.accenture.presentation.repository.RepositoryViewModel
import com.example.accenture.presentation.repository.mapper.RepositoryPaging
import org.koin.dsl.bind
import org.koin.dsl.module

val remoteModule = module {
    single<GitHubRemote> {
        GitHubRemoteImpl(get())
    }

    single {
        GithubRepository(get())
    }

    single{
        RepositoryPaging(get())
    }
}