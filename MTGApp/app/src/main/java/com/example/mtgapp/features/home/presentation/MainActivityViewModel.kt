package com.example.mtgapp.features.home.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mtgapp.features.home.data.repository.MagicQueryCardsRepository
import com.example.mtgapp.features.home.data.service.model.CardsResponse
import com.example.mtgapp.features.home.model.CardsDetailUiModel
import com.example.mtgapp.features.home.model.CardsUiModel
import kotlinx.coroutines.launch

class MainActivityViewModel constructor(
    private val repository: MagicQueryCardsRepository
) : ViewModel() {

    val responseCardList = MutableLiveData<List<CardsDetailUiModel>>()

    fun fetchCards(searchText: String) {
        viewModelScope.launch {
            try {
               repository.requestCards(searchText)?.let { cards ->
                   responseCardList.value = cards
               }
            } catch (e: Exception){
                Log.e(">>>>>>>>>>>", e.message.toString())
            }
        }
    }
}