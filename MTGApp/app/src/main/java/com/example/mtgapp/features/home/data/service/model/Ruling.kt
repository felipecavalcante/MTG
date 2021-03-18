package com.example.mtgapp.features.home.data.service.model

import com.example.mtgapp.features.home.model.RulingUiModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ruling(
    @field:Json(name = "date")
    val date: String?,
    @field:Json(name = "text")
    val text: String?
) {
    fun toUiModel(): RulingUiModel =
        RulingUiModel(
            date = date,
            text = text
        )
}

fun List<Ruling?>?.toUiModel() = this?.map {it?.toUiModel()}