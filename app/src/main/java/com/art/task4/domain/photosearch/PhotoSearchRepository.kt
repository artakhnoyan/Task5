package com.art.task4.domain.photosearch

import com.art.task4.domain.photosearch.model.PhotoList
import com.art.task4.domain.photosearch.model.PhotoRequestParam

interface PhotoSearchRepository {
    fun fetchPhotos(photoRequestParam: PhotoRequestParam): PhotoList
}