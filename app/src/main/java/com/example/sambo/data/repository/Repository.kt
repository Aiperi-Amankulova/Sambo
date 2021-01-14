package com.example.sambo.data.repository

import com.example.sambo.data.model.*
import com.example.sambo.ui.Api
import com.example.sambo.ui.fragment.home_fragment.NewModel
import retrofit2.Response

interface Repository {
    suspend fun loadData(limit: Int, page: Int): CurseModel<RowsCollection>
    suspend fun loadCategory(limit: Int, page: Int): Response<BottomSheetModel>
    suspend fun loadCards(limit: Int, page: Int): Response<CurseList>
    suspend fun loadCollections(limit: Int, page: Int): Response<ModelCollection>
    suspend fun loadNews(limit: Int, page: Int): Response<NewModel>
}

class RepositoryM(private val network: SamboInteractor) : Repository {

    override suspend fun loadData(limit: Int, page: Int): CurseList<RowsCollection> {
        return network.loadData(limit = limit, page = page)
    }

    override suspend fun loadCategory(limit: Int, page: Int): Response<BottomSheetModel> {
        return network.loadCategory(limit, page)
    }

    override suspend fun loadCards(limit: Int, page: Int): Response<CurseModel> {
        return network.loadCards(limit, page)
    }

    override suspend fun loadCollections(limit: Int, page: Int): Response<CollectionsModel> {
        return network.loadCollections(limit, page)
    }

    override suspend fun loadNews(limit: Int, page: Int): Response<NewModel> {
        return network.loadNews(limit, page)
    }
}