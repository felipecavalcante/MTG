package com.example.mtgapp.features.home.model

data class CardsDetailUiModel(
    val name: String?,
    val manaCost: String?,
    val cmc: String?,
    val colors: List<String?>?,
    val imageUrl: String?,
    val colorIdentity: List<String?>?,
    val type: String?,
    val setName: String?,
    val artist: String?,
    val originalText: String?,
    val rulings: List<RulingUiModel?>?
)