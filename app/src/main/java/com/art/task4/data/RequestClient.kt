package com.art.task4.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL: String = "https://api.picsart.com/stage/"

class RequestClient {
    private val retrofit: Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    val photoRequestService: PhotoSearchService by lazy { retrofit.create(PhotoSearchService::class.java) }
}