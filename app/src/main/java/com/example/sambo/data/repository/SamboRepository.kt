package com.example.sambo.data.repository

import com.example.sambo.data.interator.SamboInteractor
import com.example.sambo.data.model.bottom_sheet.BottomSheetModel
import com.example.sambo.data.model.home_cards.CardsModel
import com.example.sambo.data.model.home_collections.CollectionsModel
import com.example.sambo.data.model.home_courses.CoursesModel
import com.example.sambo.data.model.home_courses.RowsItem
import com.example.sambo.data.model.home_news.NewsModel
import retrofit2.Response

interface SamboRepository {
    suspend fun loadData(limit: Int, page: Int): CoursesModel<RowsItem>
    suspend fun loadCategory(limit: Int, page: Int): Response<BottomSheetModel>
    suspend fun loadCards(limit: Int, page: Int): Response<CardsModel>
    suspend fun loadCollections(limit: Int, page: Int): Response<CollectionsModel>
    suspend fun loadNews(limit: Int, page: Int): Response<NewsModel>
}

class SamboRepositoryInterator(private val network: SamboInteractor) : SamboRepository {

    override suspend fun loadData(limit: Int, page: Int): CoursesModel<RowsItem> {
        return network.loadData(limit = limit, page = page)
    }

    override suspend fun loadCategory(limit: Int, page: Int): Response<BottomSheetModel> {
        return network.loadCategory(limit, page)
    }

    override suspend fun loadCards(limit: Int, page: Int): Response<CardsModel> {
        return network.loadCards(limit, page)
    }

    override suspend fun loadCollections(limit: Int, page: Int): Response<CollectionsModel> {
        return network.loadCollections(limit, page)
    }

    override suspend fun loadNews(limit: Int, page: Int): Response<NewsModel> {
        return network.loadNews(limit, page)
    }
}