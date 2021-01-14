package com.example.sambo.data.remote

import com.example.sambo.data.model.CurseList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface SamboService {

    @GET("api/v1/categories")
    suspend fun loadCategories(
        @Query("limit") limit: Int,
        @Query("page") page: Int,
        @Query("order") order: String
    ): Response<CurseList>
}