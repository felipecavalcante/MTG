package com.example.mtgapp.features.home.data.service.model

import com.example.mtgapp.features.home.model.CardsUiModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CardsResponse(
    @field:Json(name = "cards")
    val cards: List<CardDetailsResponse>?
){
    fun toUiModel(): CardsUiModel = CardsUiModel(cards = cards.toUiModel())
}

