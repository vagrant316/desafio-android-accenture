package com.example.accenture.ui.di

import com.example.accenture.data.GithubRepository
import org.koin.dsl.module

val remoteModule = module {
    single {GithubRepository()}
}