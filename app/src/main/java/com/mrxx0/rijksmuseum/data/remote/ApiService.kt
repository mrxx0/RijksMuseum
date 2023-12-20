package com.mrxx0.rijksmuseum.data.remote

import com.mrxx0.rijksmuseum.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("en/collection")
    suspend fun getCollection(
        @Query("key") key: String,
        @Query("p") p: Int,
        @Query("ps") ps: Int
    ): ArtObjectsDtoResponse

    companion object {
        const val BASE_URL = "https://www.rijksmuseum.nl/api/"
        const val API_KEY = BuildConfig.MUSEUM_API_KEY
    }
}