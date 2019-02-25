package com.art.task4.data.photosearch

import android.arch.lifecycle.Transformations.switchMap
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.art.task4.domain.photosearch.PhotoSearchDataSourceFactory
import com.art.task4.domain.photosearch.PhotoSearchRepository
import com.art.task4.domain.photosearch.model.PhotoList
import com.art.task4.domain.photosearch.model.PhotoRequestParam

class PhotoSearchRepositoryImpl(
		private val photoSearchService: PhotoSearchService
) : PhotoSearchRepository {

	override fun fetchPhotos(photoRequestParam: PhotoRequestParam): PhotoList {
		val dataSourceFactory =
				PhotoSearchDataSourceFactory(photoSearchService, photoRequestParam)

		val pagedListConfig = PagedList.Config.Builder()
				.setInitialLoadSizeHint(photoRequestParam.limit)
				.setPageSize(photoRequestParam.limit)
				.build()

		val photos = LivePagedListBuilder(dataSourceFactory, pagedListConfig).build()

		return PhotoList(
				switchMap(dataSourceFactory.sourceLiveData) { it.requestState },
				photos
		)
	}
}