package com.example.sambo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class AsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_as)
        Handler().postDelayed({
            selectActivity()
        },4000)

    }

    private fun selectActivity(){
        if (PreferenceHelper.getIsSecondLaunch()){
            startActivity(Intent(applicationContext, OnBoardingActivity:: class.java))
            finish()
        }
        else {
            startActivity(Intent(this, OnBoardingActivity::class.java))
            finish()
        }
    }
}