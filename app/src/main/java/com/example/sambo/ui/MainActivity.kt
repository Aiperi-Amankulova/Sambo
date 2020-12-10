package com.example.sambo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.sambo.R
import com.example.sambo.ui.fragment.CompetitionFragment
import com.example.sambo.ui.fragment.EducationFragment
import com.example.sambo.ui.fragment.HomeFragment
import com.example.sambo.ui.fragment.ProfileFragment
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
        customViewPager.adapter = adapter
        adapter.addFragment(HomeFragment())
        adapter.addFragment(CompetitionFragment())
        adapter.addFragment(EducationFragment())
        adapter.addFragment(ProfileFragment())
    }

    private fun setupListeners() {
        bottomNavigation.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.home -> customViewPager.currentItem = 0
                R.id.reward -> customViewPager.currentItem = 1
                R.id.player -> customViewPager.currentItem = 2
                R.id.profile -> customViewPager.currentItem = 3
            }
            true
        }
    }
}
