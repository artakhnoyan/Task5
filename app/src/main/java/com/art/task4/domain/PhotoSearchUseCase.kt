package com.art.task4.domain

import android.arch.lifecycle.MutableLiveData

class PhotoSearchUseCase(
    private val photoSearchRepository: PhotoSearchDataSource
) : UseCase() {
    operator fun invoke(photoRequestParam: PhotoRequestParam, photoResponse: MutableLiveData<PhotoResponse>) =
        execute { photoResponse.postValue(photoSearchRepository.fetchPhotos(photoRequestParam)) }
}