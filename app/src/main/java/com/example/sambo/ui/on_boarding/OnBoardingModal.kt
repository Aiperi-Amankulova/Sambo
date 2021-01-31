package com.example.sambo.ui.on_boarding

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class OnBoardingModal(
    val text: String,
    val img: Int
) : Parcelable