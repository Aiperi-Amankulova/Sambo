package com.example.sambo.data

import com.example.sambo.data.model.BottomSheetModel
import com.example.sambo.data.model.CurseModel
import com.example.sambo.data.model.RowsModel
import com.example.sambo.ui.fragment.home_fragment.NewModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurseService {

    @GET("api/v1/educational_materials")
    suspend fun getCourses(
        @Query("page") page: Int,
        @Query("order") order: String
    ): CurseModel<RowsModel>

    @GET("api/v1/categories")
    suspend fun getBottomSheet(
        @Query("page") page: Int,
        @Query("order") order: String
    ) : Response<BottomSheetModel>

    @GET("api/v1/main_materials")
    suspend fun loadCards(
        @Query("page") page: Int,
        @Query("order") order: String
    ): Response<CardsModel>

    @GET("api/v1/selections")
    suspend fun loadCollections(
        @Query("page") page: Int,
        @Query("order") order: String
    ): Response<CardsModel>

    @GET("api/v1/articles")
    suspend fun loadNews(
        @Query("page") page: Int,
        @Query("order") order: String
    ): Response<NewModel>
}