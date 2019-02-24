package com.art.task4.data

import com.art.task4.domain.PhotoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface PhotoSearchService {

    @GET("photos/freetoedit/search.json")
    fun searchPhotos(
        @Query("query") query: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Call<PhotoResponse>
}