package com.example.sambo.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.sambo.R
import com.example.sambo.ui.MainActivity
import com.example.sambo.ui.on_boarding.OnBoardingActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            selectActivity()
        }, 3000)

    }

    private fun selectActivity() {
        if (PreferenceHelper.getIsSecondLaunch()) {
            startActivity(Intent(applicationContext, OnBoardingActivity::class.java))
            finish()
        } else {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}