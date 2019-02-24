package com.art.task4.di

import com.art.task4.data.PhotoSearchRepositoryImpl
import com.art.task4.data.RequestClient
import com.art.task4.domain.PhotoSearchRepository
import com.art.task4.domain.PhotoSearchUseCase
import com.art.task4.presenter.PhotoAdapter
import com.art.task4.presenter.PhotoLoader
import com.art.task4.presenter.PhotoSearchViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.applicationContext
import org.koin.dsl.module.module

val appModule = module {
    single { RequestClient() }
    single { PhotoLoader(get()) }


    module("photo_search") {
        factory { PhotoAdapter(get()) }
        factory<PhotoSearchRepository> { PhotoSearchRepositoryImpl(get()) }
        factory { PhotoSearchUseCase(get()) }

        viewModel { PhotoSearchViewModel(get()) }
    }
}