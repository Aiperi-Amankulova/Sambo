package com.example.sambo.data.model

import com.google.gson.annotations.SerializedName

data class CurseList(
    @SerializedName("row") val rows : List<RowsModel>,
    @SerializedName("total_count") val total_count : Int
)