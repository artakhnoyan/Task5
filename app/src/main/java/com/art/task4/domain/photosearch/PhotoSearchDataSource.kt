package com.art.task4.domain.photosearch

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PageKeyedDataSource
import com.art.task4.data.photosearch.PhotoSearchService
import com.art.task4.domain.photosearch.model.PhotoData
import com.art.task4.domain.photosearch.model.PhotoRequestParam
import com.art.task4.domain.photosearch.model.RequestState

class PhotoSearchDataSource(
		private val photoSearchService: PhotoSearchService,
		private val photoRequestParam: PhotoRequestParam
) :
		PageKeyedDataSource<Int, PhotoData>() {

	val requestState = MutableLiveData<RequestState>()

	override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, PhotoData>) {
		val photos = searchPhotos(0, params.requestedLoadSize)

		callback.onResult(photos, 0, params.requestedLoadSize)
	}

	override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, PhotoData>) {
		val photos = searchPhotos(params.key, params.requestedLoadSize)

		callback.onResult(photos, params.key + photoRequestParam.limit)
	}

	override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, PhotoData>) {
		//don't need this
	}

	private fun searchPhotos(key: Int, requestedLoadSize: Int): List<PhotoData> {
		requestState.postValue(RequestState.LOADING)
		val response =
				photoSearchService.searchPhotos(photoRequestParam.query, key, requestedLoadSize).execute()
		return if (response.isSuccessful) {
			val photoResponse = response.body()
			requestState.postValue(RequestState.LOADED)

			photoResponse?.photos?.map { PhotoData(it.id, it.url) } ?: emptyList()
		} else {
			requestState.postValue(RequestState.failure(response.errorBody()?.string()))

			emptyList()
		}
	}
}