package com.example.sambo.di

import com.example.sambo.data.repository.Repository
import com.example.sambo.data.repository.RepositoryM
import com.example.sambo.ui.Api
import com.example.sambo.ui.ApiImpl
import com.example.sambo.ui.fragment.home_fragment.HomeViewModel
import com.example.sambo.ui.fragment.education_fragment.EducationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val MModules = module {
    viewModel { EducationViewModel() }
    viewModel { HomeViewModel(get()) }
}

val RepositoryModules = module {
    single<Repository> { RepositoryM(get()) }
}

val ApiModules = module {
    single<Api> { ApiImpl(get()) }
}

val modules = listOf(ApiModules, RepositoryModules, MModules)