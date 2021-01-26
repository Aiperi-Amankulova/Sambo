package com.example.sambo.data.di

import com.example.sambo.data.interator.SamboInteractor
import com.example.sambo.data.interator.SamboInteratorService
import com.example.sambo.data.remote.CoursesService
import com.example.sambo.data.remote.RetrofitBuilder
import com.example.sambo.data.repository.SamboRepository
import com.example.sambo.data.repository.SamboRepositoryInterator
import com.example.sambo.ui.fragment.home_fragment.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


val viewModelModule: Module = module {
    viewModel { CoursesViewModel(get()) }
    viewModel { HomeViewModel(get()) }
}

val repositoryModule: Module = module {
    single<SamboRepository> { SamboRepositoryInterator(get()) }
}

val Module: Module = module {
    single<CoursesService> { RetrofitBuilder.buildRetrofit() }
    single<SamboInteractor> { SamboInteratorService(get()) }
}

val Modules =
    listOf(viewModelModule, Module, repositoryModule)