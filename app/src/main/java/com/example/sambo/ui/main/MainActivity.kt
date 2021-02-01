package com.example.sambo.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sambo.R
import com.example.sambo.util.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomView()
    }

    private fun setupBottomView() {
        val navView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val navIds = listOf(
            R.navigation.home,
            R.navigation.competition,
            R.navigation.education,
            R.navigation.profile
        )

        navView.setupWithNavController(
            navGraphIds = navIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.main_navigation,
            intent = intent
        )
    }
}