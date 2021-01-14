package com.example.sambo.data.model

import com.google.gson.annotations.SerializedName

data class RowsModel(
    @SerializedName("id") val id : Int,
    @SerializedName("title") val title : String,
    @SerializedName("content") val content : String,
    @SerializedName("status_code") val status_code : String,
    @SerializedName("created_at") val created_at : String,
    @SerializedName("updated_at") val updated_at : String,
    @SerializedName("email") val email : String,
    @SerializedName("preview") val preview : String,
    @SerializedName("comments_count") val comments_count : Int
)