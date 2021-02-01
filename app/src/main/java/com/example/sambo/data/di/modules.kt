package com.example.sambo.data.di


import com.example.sambo.data.interator.SamboInteractor
import com.example.sambo.data.interator.SamboInterator
import com.example.sambo.data.remote.RetrofitBuilder
import com.example.sambo.data.repository.SamboRepository
import com.example.sambo.data.repository.SamboRepositoryInterator
import com.example.sambo.ui.fragment.education_fragment.EducationViewModel
import com.example.sambo.ui.fragment.home_fragment.HomeViewModel
import com.example.sambo.ui.fragment.home_fragment.collection.CollectionsDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


val viewModelModule: Module = module {
    viewModel { EducationViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { CollectionsDetailsViewModel(get()) }
}


val repositoryModule: Module = module {
    single<SamboRepository> { SamboRepositoryInterator(get()) }
}

val apiModule: Module = module {
    single { RetrofitBuilder.buildRetrofit() }
    single<SamboInteractor> { SamboInterator(get()) }
}

val appModules =
    listOf(viewModelModule, apiModule, repositoryModule)