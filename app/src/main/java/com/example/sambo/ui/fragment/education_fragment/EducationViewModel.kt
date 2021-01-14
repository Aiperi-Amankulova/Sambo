package com.example.sambo.ui.fragment.education_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sambo.data.model.RowsModel

class EducationViewModel() : ViewModel() {

    val dataEducation = MutableLiveData<List<RowsModel>>()

    init {
        mainLoading()
    }

    fun mainLoading() {
    }
}