package com.example.sambo.data.model.home_cards

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class RowsItem(
    val comments_count: Int,
    val content: String,
    val created_at: String,
    val description: String,
    val document: String,
    val duration: String,
    val id: Int,
    val email: String,
    val status_code: String,
    val material_type: String,
    val preview: String,
    val rank: Int,
    val title: String,
    val updated_at: String
) : Parcelable

