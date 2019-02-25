package com.art.task4.domain.photosearch.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @Expose val status: String,
    @SerializedName("response") val photos: List<Photo>
)
data class Photo(
    @Expose val id: Long,
    @Expose val url: String
)