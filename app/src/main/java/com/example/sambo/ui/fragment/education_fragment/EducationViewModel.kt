package com.example.sambo.ui.fragment.education_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sambo.data.model.bottom_sheet.BottomSheetRows
import com.example.sambo.data.model.cammon.BasePagedViewModel
import com.example.sambo.data.model.cammon.DataBase
import com.example.sambo.data.model.home_educations.EducationModel
import com.example.sambo.data.model.home_educations.RowsItem
import com.example.sambo.data.repository.SamboRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class EducationViewModel(private val service: SamboRepository) : BasePagedViewModel<RowsItem, EducationViewModel.EducationSource>() {


    override val sourceFactory by lazy {
        DataBase.Factory {
            EducationSource(viewModelScope)
        }
    }

    val data = getPagedList()
    val dataCategory = MutableLiveData<List<BottomSheetRows>>()


    fun loadList() {
        viewModelScope.launch {
            val result = service.loadCategory(limit = 20, page = 1)
            if (result.isSuccessful) dataCategory.postValue(result.body()?.rows)
        }
    }

    inner class EducationSource(
        scope: CoroutineScope
    ) : DataBase<RowsItem>(scope) {
        override fun getListByPageNumber(limit: Int, page: Int): EducationModel<RowsItem>? {
            return runBlocking {
                val data = service.loadData(limit = limit, page = page)
                return@runBlocking data
            }
        }
    }
}

