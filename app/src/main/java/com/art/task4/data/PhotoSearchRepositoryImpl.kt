package com.art.task4.data

import com.art.task4.domain.PhotoRequestParam
import com.art.task4.domain.PhotoResponse
import com.art.task4.domain.PhotoSearchRepository
import com.art.task4.domain.PhotoSearchDataSource

class PhotoSearchRepositoryImpl(
    private val photoSearchDataSource: PhotoSearchDataSource
) : PhotoSearchRepository {

    override fun fetchPhotos(photoRequestParam: PhotoRequestParam): PhotoResponse {
        with(photoRequestParam) { return photoSearchDataSource.searchPhoto(query, offset, limit) }
    }
}