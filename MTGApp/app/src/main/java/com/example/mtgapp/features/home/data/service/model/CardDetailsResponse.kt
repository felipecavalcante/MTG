package com.example.mtgapp.features.home.data.service.model

import com.example.mtgapp.features.home.model.CardsDetailUiModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CardDetailsResponse(
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "manaCost")
    val manaCost: String?,
    @field:Json(name = "cmc")
    val cmc: String?,
    @field:Json(name = "colors")
    val colors: List<String?>?,
    @field:Json(name = "imageUrl")
    val imageUrl: String?,
    @field:Json(name = "colorIdentity")
    val colorIdentity: List<String?>?,
    @field:Json(name ="type")
    val type: String?,
    @field:Json(name = "setName")
    val setName: String?,
    @field:Json(name = "artist")
    val artist: String?,
    @field:Json(name = "originalText")
    val originalText: String?,
    @field:Json(name = "rulings")
    val rulings: List<Ruling?>?
) {
    fun toUiModel() : CardsDetailUiModel{
        return CardsDetailUiModel(
            name = name,
            manaCost = manaCost,
            cmc = cmc,
            colors = colors,
            imageUrl = imageUrl,
            colorIdentity = colorIdentity,
            type = type,
            setName =setName,
            artist = artist,
            originalText =originalText,
            rulings = rulings.toUiModel()
        )
    }
}

fun List<CardDetailsResponse>?.toUiModel() = this?.map {it.toUiModel()}