package com.example.sambo.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataOnBoard (
    val image : Int,
    val text : String
) : Parcelable