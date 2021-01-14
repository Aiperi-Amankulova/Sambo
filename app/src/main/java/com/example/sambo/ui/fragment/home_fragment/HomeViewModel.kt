package com.example.sambo.ui.fragment.home_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sambo.data.model.CurseList
import com.example.sambo.data.model.ModelCollection
import com.example.sambo.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository) :  ViewModel() {

    val cardsData = MutableLiveData<CurseList>()
    val collectionsData = MutableLiveData<ModelCollection>()
    val newsData = MutableLiveData<NewModel>()

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
}

