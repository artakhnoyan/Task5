package com.art.task4.domain

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import com.art.task4.presenter.PhotoData

class PhotoSearchDataSourceFactory : DataSource.Factory<Int, PhotoData>() {

    private val mutableLiveData: MutableLiveData<PhotoSearchDataSource> = MutableLiveData()
    private lateinit var feedDataSource: PhotoSearchDataSource

    override fun create(): DataSource<Int, PhotoData> {
        feedDataSource = PhotoSearchDataSource()
        mutableLiveData.postValue(feedDataSource)
        return feedDataSource
    }

    fun getMutableLiveData(): MutableLiveData<PhotoSearchDataSource> {
        return mutableLiveData
    }
}