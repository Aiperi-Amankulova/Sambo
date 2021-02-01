package com.example.sambo.data.repository

import com.example.sambo.data.interator.SamboInteractor
import com.example.sambo.data.interator.SamboInterator
import com.example.sambo.data.model.tip_the_day.TipOfTheDayModal
import com.example.sambo.data.model.bottom_sheet.BottomSheetModel
import com.example.sambo.data.model.home_cards.CardsModel
import com.example.sambo.data.model.home_collections.CollectionsModel
import com.example.sambo.data.model.home_educations.EducationModel
import com.example.sambo.data.model.home_educations.RowsItem
import com.example.sambo.data.model.home_news.NewsModel
import com.example.sambo.data.remote.EducationsService
import retrofit2.Response



interface SamboRepository {
    suspend fun loadData(limit: Int, page: Int): EducationModel<RowsItem>
    suspend fun loadCategory(limit: Int, page: Int): Response<BottomSheetModel>
    suspend fun loadCards(limit: Int, page: Int): Response<CardsModel>
    suspend fun loadCollections(limit: Int, page: Int): Response<CollectionsModel>
    suspend fun loadNews(limit: Int, page: Int): Response<NewsModel>
    suspend fun loadSelectionsData(limit: Int, selectionId : Int, page: Int): Response<CollectionsModel>
    suspend fun tips(): TipOfTheDayModal
}

class SamboRepositoryInterator(private val network: SamboInteractor) : SamboRepository {

    override suspend fun loadData(limit: Int, page: Int): EducationModel<RowsItem> {
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

    override suspend fun loadSelectionsData(
        limit: Int,
        selectionId: Int,
        page: Int
    ): Response<CollectionsModel> {
        return network.loadSelectionsData(limit, selectionId, page)
    }

    override suspend fun tips(): TipOfTheDayModal {
        return network.tips()
    }


}