package com.example.sambo.data.model.tip_the_day

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TipOfTheDayModal(
    val created_at: String,
    val description: String,
    val name: String,
    val updated_at: String
) : Parcelable