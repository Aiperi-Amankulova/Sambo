package com.example.sambo.data

import com.example.sambo.data.model.RowsCollection


data class  CardsModel(
    val rows: List<RowsCollection>,
    val total_count: Int
)