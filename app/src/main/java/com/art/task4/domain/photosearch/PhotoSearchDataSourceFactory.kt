package com.art.task4.domain.photosearch

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import com.art.task4.data.photosearch.PhotoSearchService
import com.art.task4.domain.photosearch.model.PhotoData
import com.art.task4.domain.photosearch.model.PhotoRequestParam

class PhotoSearchDataSourceFactory(
    private val photoSearchService: PhotoSearchService,
    private val photoRequestParam: PhotoRequestParam
) : DataSource.Factory<Int, PhotoData>() {
    private lateinit var feedDataSource: PhotoSearchDataSource
    val sourceLiveData: MutableLiveData<PhotoSearchDataSource> = MutableLiveData()

    override fun create(): DataSource<Int, PhotoData> {
        feedDataSource = PhotoSearchDataSource(photoSearchService, photoRequestParam)
        sourceLiveData.postValue(feedDataSource)
        return feedDataSource
    }
}