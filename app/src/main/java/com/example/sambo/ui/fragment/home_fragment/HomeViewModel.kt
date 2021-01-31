package com.example.sambo.ui.fragment.home_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sambo.data.model.home_cards.CardsModel
import com.example.sambo.data.model.home_collections.CollectionsModel
import com.example.sambo.data.model.home_news.NewsModel
import com.example.sambo.data.model.tip_the_day.TipOfTheDayModal
import com.example.sambo.data.repository.SamboRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: SamboRepository) :  ViewModel() {

    val cardsData = MutableLiveData<CardsModel>()
    val collectionsData = MutableLiveData<CollectionsModel>()
    val newsData = MutableLiveData<NewsModel>()
    private val tips = MutableLiveData<TipOfTheDayModal>()

    fun loadCards() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val result = repository.loadCards(20,1)
                cardsData.postValue(result?.body())
            }.onFailure {

            }
        }
    }

    fun loadCollections() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val result = repository.loadCollections(20,1)
                collectionsData.postValue(result?.body())
            }.onFailure {

            }
        }
    }

    fun loadNews() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val result = repository.loadNews(20,1)
                newsData.postValue(result?.body())
            }.onFailure {

            }
        }
    }

    fun tips() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val result = repository.tips()
                tips.postValue(result)
            }.onFailure {

            }
        }
    }
}

