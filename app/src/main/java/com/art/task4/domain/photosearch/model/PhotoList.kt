package com.art.task4.domain.photosearch.model

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList

data class PhotoList(
		val requestState: LiveData<RequestState>,
		val pagedListPhotos: LiveData<PagedList<PhotoData>>
)