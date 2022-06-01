package com.example.accenture.ui.di

import com.example.accenture.presentation.repository.RepositoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { RepositoryViewModel(get())
    }
}