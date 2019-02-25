package com.art.task4.domain.photosearch

import android.arch.lifecycle.MutableLiveData
import com.art.task4.domain.UseCase
import com.art.task4.domain.photosearch.model.PhotoList
import com.art.task4.domain.photosearch.model.PhotoRequestParam

class PhotoSearchUseCase(
    private val photoSearchRepository: PhotoSearchRepository
) : UseCase() {
    operator fun invoke(photoRequestParam: PhotoRequestParam, photoList: MutableLiveData<PhotoList>) =
        execute { photoList.postValue(photoSearchRepository.fetchPhotos(photoRequestParam)) }
}