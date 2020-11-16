package com.example.sambo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.sambo.ui.MainActivity

class Splashactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            selectActivity()
        },4000)

    }

    private fun selectActivity(){
        if (PreferenceHelper.getIsSecondLaunch()){
            startActivity(Intent(applicationContext, MainActivity:: class.java))
            finish()
        }
        else {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}