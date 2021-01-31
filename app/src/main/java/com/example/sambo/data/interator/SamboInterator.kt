package com.example.sambo.data.interator

import com.example.sambo.data.model.bottom_sheet.BottomSheetModel
import com.example.sambo.data.model.home_cards.CardsModel
import com.example.sambo.data.model.home_educations.RowsItem

import com.example.sambo.data.model.home_collections.CollectionsModel
import com.example.sambo.data.model.home_educations.EducationModel
import com.example.sambo.data.model.home_news.NewsModel
import com.example.sambo.data.model.tip_the_day.TipOfTheDayModal
import com.example.sambo.data.remote.EducationsService
import retrofit2.Response

interface SamboInteractor{
    suspend fun loadData(limit: Int, page: Int) : EducationModel<RowsItem>
    suspend fun loadCategory(limit: Int,page: Int)  : Response<BottomSheetModel>
    suspend fun loadCards(limit: Int, page: Int): Response<CardsModel>
    suspend fun loadCollections(limit: Int, page: Int): Response<CollectionsModel>
    suspend fun loadNews(limit: Int, page: Int): Response<NewsModel>
    suspend fun loadSelectionsData(limit: Int, selectionId : Int, page: Int): Response<CollectionsModel>
    suspend fun tips(): TipOfTheDayModal
}

class SamboInterator (private val service : EducationsService) : SamboInteractor {

    override suspend fun loadData(limit: Int, page: Int): EducationModel<RowsItem> {
        return service.getCourses(limit = limit, page = page,order = "{\"id\":\"asc\"}")
    }

    override suspend fun loadCategory(limit: Int, page: Int): Response<BottomSheetModel> {
        return service.getBottomSheet(limit=20,page = 1,order ="{\"id\":\"asc\"}")
    }

    override suspend fun loadCards(limit: Int, page: Int): Response<CardsModel> {
        return service.loadCards(limit = limit, page = page, order = "{\"rank\":\"asc\"}")
    }

    override suspend fun loadCollections(limit: Int, page: Int): Response<CollectionsModel> {
        return service.loadCollections(limit = limit, page = page, order = "{\"rank\":\"asc\"}")
    }

    override suspend fun loadNews(limit: Int, page: Int): Response<NewsModel> {
        return service.loadNews(limit = limit, page = page, order = "{\"created_at\":\"asc\"}")
    }

    override suspend fun loadSelectionsData(
        limit: Int,
        selectionId: Int,
        page: Int
    ): Response<CollectionsModel> {
        return service.loadSelectionsData(limit, selectionId, page)
    }

    override suspend fun tips(): TipOfTheDayModal {
        return service.tips()
    }

}