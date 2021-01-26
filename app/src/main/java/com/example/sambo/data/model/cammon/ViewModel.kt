package com.example.sambo.data.model.cammon

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

abstract class ViewModel < T, D : DataBase<T>> : ViewModel() {

    abstract val sourceFactory : DataBase.Factory<T, D>

    fun getPagedList(): LiveData<PagedList<T>> {
        return  LivePagedListBuilder(
            sourceFactory,
            PagedList.Config.Builder()
                .setPageSize(20)
                .build()
        ) .build()
    }
}