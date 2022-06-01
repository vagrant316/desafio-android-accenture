package com.example.accenture.ui.di

import com.example.accenture.data.GithubRepository
import com.example.accenture.data.remote.GitHubRemoteImpl
import com.example.accenture.data.source.GitHubRemote
import org.koin.dsl.module
import org.koin.dsl.single

val remoteModule = module {
    single<GitHubRemote> {
        GitHubRemoteImpl(get())
    }

    single<GithubRepository>()


}