package com.art.task4.domain

import android.arch.paging.PageKeyedDataSource
import com.art.task4.presenter.PhotoData

class PhotoSearchDataSource(private val photoSearchRepository: PhotoSearchRepository) :
    PageKeyedDataSource<Int, PhotoData>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, PhotoData>) {
        photoSearchRepository.fetchPhotos(PhotoRequestParam())
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, PhotoData>) {
        photoSearchRepository.fetchPhotos(PhotoRequestParam(offset = params.key, limit = params.requestedLoadSize))

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, PhotoData>) {
    }
}