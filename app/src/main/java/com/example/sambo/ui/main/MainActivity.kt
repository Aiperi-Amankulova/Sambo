package com.example.sambo.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sambo.R
import com.example.sambo.ui.ViewPagerAdapter
import com.example.sambo.ui.fragment.CompetitionFragment
import com.example.sambo.ui.fragment.home_fragment.HomeFragment
import com.example.sambo.ui.fragment.education_fragment.EducationFragment
import com.example.sambo.ui.fragment.profile_fragment.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNav()
        setupListeners()
    }

    private fun setupBottomNav() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        custom_view_pager.adapter = adapter
        adapter.addFragment(HomeFragment())
        adapter.addFragment(CompetitionFragment())
        adapter.addFragment(EducationFragment())
        adapter.addFragment(ProfileFragment())
    }

    private fun setupListeners() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> custom_view_pager.currentItem = 0
                R.id.reward -> custom_view_pager.currentItem = 1
                R.id.player -> custom_view_pager.currentItem = 2
                R.id.profile -> custom_view_pager.currentItem = 3
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}
