package com.example.sambo.data.model

import com.google.gson.annotations.SerializedName

data class RowsCollection (
    @SerializedName("id") val id : Int,
    @SerializedName("icon") val icon : String,
    @SerializedName("title") val title: String,
    @SerializedName("created_at") val created_at : String,
    @SerializedName("updated_at") val updated_at : String,
    @SerializedName("rank") val rank : String,
)