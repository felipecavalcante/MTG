package com.example.mtgapp.features.home.data.repository

import com.example.mtgapp.features.home.data.service.MagicQueryService
import com.example.mtgapp.features.home.data.service.model.CardsResponse
import com.example.mtgapp.features.home.data.service.model.toUiModel
import com.example.mtgapp.features.home.model.CardsDetailUiModel
import com.example.mtgapp.features.home.model.CardsUiModel

interface MagicQueryCardsRepository {
    suspend fun requestCards(name: String?): List<CardsDetailUiModel>?

    class Impl constructor(private val service: MagicQueryService): MagicQueryCardsRepository{
        override suspend fun requestCards(name: String?): List<CardsDetailUiModel>? {
            return service.getAllCards(name).cards.toUiModel()
        }
    }
}