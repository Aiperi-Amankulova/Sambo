package com.example.sambo.data.model

import com.google.gson.annotations.SerializedName

class CurseModel <Y> (
    @SerializedName("rows") val rows : List<Y>,
    @SerializedName("total_count") val total_count : Int
)