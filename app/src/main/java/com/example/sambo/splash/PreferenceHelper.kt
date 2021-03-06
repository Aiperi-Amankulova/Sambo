package com.example.sambo.splash

import android.content.Context
import android.content.SharedPreferences

object PreferenceHelper {
    private const val PREFERENCE_NAME = "SamboPreference"
    private const val IS_FIRST_LAUNCH = "IS_FIRST_LAUNCH"


    private var preference: SharedPreferences? = null

    fun init(context: Context){
        preference = context.getSharedPreferences(
            PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    fun setIsFirstLaunch(){
        preference?.edit()?.putBoolean(
            IS_FIRST_LAUNCH,false)?.apply()
    }

    fun getIsFirstLaunch() = preference?.getBoolean(
        IS_FIRST_LAUNCH,true) ?: true

    fun clear(){
        preference?.edit()?.clear()?.apply()
    }
}