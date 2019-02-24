package com.art.task4.presenter

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.art.task4.domain.PhotoSearchDataSourceFactory
import com.art.task4.domain.PhotoSearchUseCase


class PhotoSearchViewModel(private val photoSearchUseCase: PhotoSearchUseCase) : ViewModel() {


    //    private val _photos: MutableLiveData<PhotoResponse>
    var photos: LiveData<PagedList<PhotoData>>

    init {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(10)
            .setPageSize(20).build()
        val dataSource = PhotoSearchDataSourceFactory()
        photos = LivePagedListBuilder(dataSource, pagedListConfig).build()
    }


    fun searchPhoto() {
//        photoSearchUseCase(PhotoRequestParam(), _photos)
    }

}

class PhotoData(val url: String)
