package com.art.task4.di

import com.art.task4.data.photosearch.PhotoSearchRepositoryImpl
import com.art.task4.data.photosearch.PhotoSearchService
import com.art.task4.data.RequestClient
import com.art.task4.domain.photosearch.PhotoSearchRepository
import com.art.task4.domain.photosearch.PhotoSearchUseCase
import com.art.task4.presenter.photosearch.PhotoAdapter
import com.art.task4.presenter.PhotoLoader
import com.art.task4.presenter.photosearch.PhotoSearchViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

private val appModule = module {
    single { PhotoLoader(get()) }
}

private val photoSearchModule = module {
    factory { PhotoAdapter(get()) }

    factory<PhotoSearchRepository> { PhotoSearchRepositoryImpl(photoSearchService) }
    factory { PhotoSearchUseCase(get()) }
    viewModel { PhotoSearchViewModel(get()) }
}

private val requestClient = RequestClient()
private val photoSearchService: PhotoSearchService = requestClient.photoRequestService


val modules = listOf(appModule, photoSearchModule)