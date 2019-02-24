package com.art.task4.domain

interface PhotoSearchRepository {
    fun fetchPhotos(photoRequestParam: PhotoRequestParam): PhotoResponse
}