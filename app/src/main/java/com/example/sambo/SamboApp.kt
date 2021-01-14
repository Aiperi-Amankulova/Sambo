package com.example.sambo

import android.app.Application
import org.koin.core.context.startKoin
import com.example.sambo.di.modules
import com.example.sambo.splash.PreferenceHelper
import org.koin.android.ext.koin.androidContext

class SamboApp : Application() {
    override fun onCreate() {
        super.onCreate()
        PreferenceHelper.init(applicationContext)
        startKoin { androidContext(this@SamboApp)
            modules(modules)
        }
    }
}