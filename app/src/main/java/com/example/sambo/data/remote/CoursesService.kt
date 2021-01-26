package com.example.sambo.data.remote

import com.example.sambo.data.model.bottom_sheet.BottomSheetModel
import com.example.sambo.data.model.home_cards.CardsModel
import com.example.sambo.data.model.home_collections.CollectionsModel
import com.example.sambo.data.model.home_courses.CoursesModel
import com.example.sambo.data.model.home_courses.RowsItem
import com.example.sambo.data.model.home_news.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CoursesService {

    @GET("api/v1/educational_materials")
    suspend fun getCourses(
        @Query("limit") limit: Int,
        @Query("page") page: Int ,
        @Query("order") order: String
    ): CoursesModel<RowsItem>

    @GET("api/v1/categories")
    suspend fun getBottomSheet(
        @Query("limit") limit: Int,
        @Query("page") page: Int ,
        @Query("order") order: String
    ) : Response<BottomSheetModel>

    @GET("api/v1/main_materials")
    suspend fun loadCards(
        @Query("limit") limit: Int,
        @Query("page") page: Int ,
        @Query("order") order: String
    ): Response<CardsModel>

    @GET("api/v1/selections")
    suspend fun loadCollections(
        @Query("limit") limit: Int,
        @Query("page") page: Int ,
        @Query("order") order: String
    ): Response<CollectionsModel>

    @GET("api/v1/articles")
    suspend fun loadNews(
        @Query("limit") limit: Int,
        @Query("page") page: Int ,
        @Query("order") order: String
    ): Response<NewsModel>
}