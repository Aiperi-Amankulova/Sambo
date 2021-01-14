package com.example.sambo.data.model

import com.google.gson.annotations.SerializedName

class ModelCollection (
    @SerializedName("rows") val rows : List<RowsCollection>,
    @SerializedName("total_count") val total_count : Int
)