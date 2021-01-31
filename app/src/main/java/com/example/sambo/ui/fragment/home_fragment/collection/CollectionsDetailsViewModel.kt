package com.example.sambo.ui.fragment.home_fragment.collection

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sambo.data.model.home_collections.CollectionsModel
import com.example.sambo.data.repository.SamboRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CollectionsDetailsViewModel (private val repository: SamboRepository)  : ViewModel() {

    val collectionsData = MutableLiveData<CollectionsModel>()

    fun loadSelectionsData(categoryId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val result = repository.loadSelectionsData(20,categoryId,1)
                collectionsData.postValue(result.body())
            }.onFailure {

            }
        }
    }
}