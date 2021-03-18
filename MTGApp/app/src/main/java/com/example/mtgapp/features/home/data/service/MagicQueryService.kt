package com.example.mtgapp.features.home.data.service

import com.example.mtgapp.features.home.data.service.model.CardsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MagicQueryService {
    @GET("v1/cards")
    suspend fun getAllCards(
        @Query("name")
        name: String? = ""
    ): CardsResponse
}