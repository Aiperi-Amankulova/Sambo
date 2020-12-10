package com.example.sambo.ui.on_boarding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.sambo.R
import com.example.sambo.data.DataOnBoard
import com.example.sambo.ui.MainActivity
import com.example.sambo.ui.RegistrationActivity
import kotlinx.android.synthetic.main.page_on_boarding.*

class OnBoardingActivity : AppCompatActivity() {
    private val list = arrayListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_on_boarding)
        setupViewPager()
        setupListener()
    }

    private fun setupListener() {
        vp_page.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
            ) {
            }
            override fun onPageSelected(position: Int) {
                if (checktoPage(position)) {
                    btn_go.text = "Продолжить"
                } else {
                    btn_go.text = "Пропустить"
                }
            }
            override fun onPageScrollStateChanged(state: Int) {}
        })

        btn_go.setOnClickListener {
            if (checktoPage(vp_page.currentItem)) {
                startActivity(Intent(this, RegistrationActivity::class.java))
                finish()
            } else {
                vp_page.currentItem += 1
            }
        }
    }

    private fun checktoPage(position: Int) = position == list.size - 1

    private fun setupViewPager() {
        val adapterl = OnBoardingAdapter(supportFragmentManager)
        vp_page.adapter = adapterl
        list.add(OnBoardingFragment.getInstance(DataOnBoard(R.drawable.thir, getString(R.string.first_text_in_onboard))))
        list.add(OnBoardingFragment.getInstance(DataOnBoard(R.drawable.se, getString(R.string.second_text_in_onboard))))
        list.add(OnBoardingFragment.getInstance(DataOnBoard(R.drawable.first_onb, getString(R.string.third_text_in_onboard))))
        adapterl.update(list)
        slide.setupWithViewPager(vp_page)
    }
}