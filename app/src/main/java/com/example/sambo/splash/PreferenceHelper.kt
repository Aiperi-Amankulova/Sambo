package com.example.sambo.splash

import android.content.Context
import android.content.SharedPreferences

object PreferenceHelper {
    private const val PREFERENCE_NAME = "Fitness_preference"
    private const val IS_FIRST_LAUNCH = "IS_FIRST_LAUNCH"

    private var preference: SharedPreferences? = null
    fun initPreference(context: Context) {
        preference = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    fun setIsFirstLaunch() {
        preference?.edit()?.putBoolean(IS_FIRST_LAUNCH, false)?.apply()
    }

    fun getIsSecondLaunch() = preference?.getBoolean(IS_FIRST_LAUNCH, true) ?: true
}