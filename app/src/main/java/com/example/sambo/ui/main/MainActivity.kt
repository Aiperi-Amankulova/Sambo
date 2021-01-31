package com.example.sambo.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sambo.R
import com.example.sambo.ui.ViewPagerAdapter
import com.example.sambo.ui.fragment.CompetitionFragment
import com.example.sambo.ui.fragment.education_fragment.EducationFragment
import com.example.sambo.ui.fragment.home_fragment.HomeFragment
import com.example.sambo.ui.fragment.profile_fragment.ProfileFragment
import com.example.sambo.utils.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomView()
    }

    private fun setupBottomView() {
        val mainView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val mainNavigation = listOf(
            R.navigation.home,
            R.navigation.competition,
            R.navigation.education,
            R.navigation.profile
        )

        mainView.setupWithNavController(
            navGraphIds = mainNavigation,
            fragmentManager = supportFragmentManager,
            containerId = R.id.main_fragment,
            intent = intent
        )
    }
}
