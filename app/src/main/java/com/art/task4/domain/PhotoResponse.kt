package com.art.task4.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @Expose val status: String = "",
    @SerializedName("response") val photos: List<Photo> = listOf()
)

data class Photo(
    @Expose val id: Long,
    @Expose val url: String,
    @Expose val width: Int,
    @Expose val height: Int
)