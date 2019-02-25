package com.art.task4.data.photosearch

import com.art.task4.domain.photosearch.model.PhotoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface PhotoSearchService {
    @GET("photos/freetoedit/search.json")
    fun searchPhotos(
        @Query("q") query: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Call<PhotoResponse>
}