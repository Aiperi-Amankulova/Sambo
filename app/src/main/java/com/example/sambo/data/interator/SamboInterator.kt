package com.example.sambo.data.interator

import com.example.sambo.data.model.bottom_sheet.BottomSheetModel
import com.example.sambo.data.model.home_cards.CardsModel
import com.example.sambo.data.model.home_collections.CollectionsModel
import com.example.sambo.data.model.home_courses.CoursesModel
import com.example.sambo.data.model.home_courses.RowsItem
import com.example.sambo.data.model.home_news.NewsModel
import com.example.sambo.data.remote.CoursesService
import retrofit2.Response

interface SamboInteractor{
    suspend fun loadData(limit: Int, page: Int) : CoursesModel<RowsItem>
    suspend fun loadCategory(limit: Int,page: Int)  : Response<BottomSheetModel>
    suspend fun loadCards(limit: Int, page: Int): Response<CardsModel>
    suspend fun loadCollections(limit: Int, page: Int): Response<CollectionsModel>
    suspend fun loadNews(limit: Int, page: Int): Response<NewsModel>
}

class SamboInteratorService (private val service : CoursesService) : SamboInteractor{
    override suspend fun loadData(limit: Int, page: Int): CoursesModel<RowsItem> {
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

}