package com.art.task4.presenter.photosearch

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations.switchMap
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import com.art.task4.domain.photosearch.PhotoSearchUseCase
import com.art.task4.domain.photosearch.model.PhotoData
import com.art.task4.domain.photosearch.model.PhotoList
import com.art.task4.domain.photosearch.model.PhotoRequestParam
import com.art.task4.domain.photosearch.model.RequestState

class PhotoSearchViewModel(
		private val photoSearchUseCase: PhotoSearchUseCase
) : ViewModel() {
	private val _photoList: MutableLiveData<PhotoList> = MutableLiveData()

	val photos: LiveData<PagedList<PhotoData>> = switchMap(_photoList) { it.pagedListPhotos }!!
	val requestState: LiveData<RequestState> = switchMap(_photoList) { it.requestState }!!


	fun searchPhoto(query: String = "") {
		photoSearchUseCase(PhotoRequestParam(query = query, limit = 20), _photoList)
	}

}

