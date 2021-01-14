package com.example.sambo.ui

import com.example.sambo.data.model.CurseList
import com.example.sambo.data.remote.SamboService
import retrofit2.Response

interface Api {

    suspend fun loadData(): Response<CurseList>
}

class ApiImpl(private val service: SamboService) : Api {

    override suspend fun loadData(): Response<CurseList> {
        return service.loadCategories(limit = 20, page = 1, order = "{\"rank\":\"asc\"}")
    }

}