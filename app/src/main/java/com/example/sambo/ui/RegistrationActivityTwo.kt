package com.example.sambo.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sambo.R
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.page_registration_two.*

class RegistrationActivityTwo:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_registration_two)
        setupListener()
    }
    private fun setupListener(){
        btn_sam.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}