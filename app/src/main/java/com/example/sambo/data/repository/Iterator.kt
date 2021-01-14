package com.example.sambo.data.repository

import com.example.sambo.data.CardsModel
import com.example.sambo.data.CurseService
import com.example.sambo.data.model.BottomSheetModel
import com.example.sambo.data.model.CurseModel
import com.example.sambo.data.model.RowsModel
import com.example.sambo.ui.fragment.home_fragment.NewModel
import retrofit2.Response

interface Iterator {
    suspend fun loadData(limit: Int, page: Int) :CurseModel<RowsModel>
    suspend fun loadCategory(limit: Int,page: Int)  : Response<BottomSheetModel>
    suspend fun loadCards(limit: Int, page: Int): Response<CardsModel>
    suspend fun loadCollections(limit: Int, page: Int): Response<CollectionsModel>
    suspend fun loadNews(limit: Int, page: Int): Response<NewModel>
}

class IteratorSambo (private val service : CurseService) : Iterator{
    override suspend fun loadData(limit: Int, page: Int): CurseModel<RowsModel> {
    }

    override suspend fun loadCategory(limit: Int, page: Int): Response<BottomSheetModel> {
    }

    override suspend fun loadCards(limit: Int, page: Int): Response<CardsModel> {
    }

    override suspend fun loadCollections(limit: Int, page: Int): Response<CollectionsModel> {
    }

    override suspend fun loadNews(limit: Int, page: Int): Response<NewModel> {
    }
}