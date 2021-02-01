package com.example.sambo

import android.app.Application
import com.example.sambo.data.di.appModules
import com.example.sambo.splash.PreferenceHelper
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SamboApp : Application() {
    override fun onCreate() {
        super.onCreate()
        PreferenceHelper.init(applicationContext)
        startKoin { androidContext(this@SamboApp)
            modules(appModules)
        }
    }
}