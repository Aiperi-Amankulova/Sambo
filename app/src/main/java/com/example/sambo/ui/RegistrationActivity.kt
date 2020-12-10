package com.example.sambo.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sambo.R
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.page_on_boarding.*

class RegistrationActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        setupListener()
    }
    private fun setupListener(){
        btn_regis.setOnClickListener {
                startActivity(Intent(this, RegistrationActivityTwo::class.java))
                finish()
            }
        }
    }
