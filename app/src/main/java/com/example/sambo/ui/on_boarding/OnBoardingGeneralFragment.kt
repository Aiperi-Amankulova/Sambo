package com.example.sambo.ui.on_boarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.sambo.R
import com.example.sambo.data.DataOnBoard
import com.example.sambo.splash.PreferenceHelper
import com.example.sambo.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.page_on_boarding.*

class OnBoardingGeneralFragment : BaseFragment() {
    private val list = arrayListOf<Fragment>()
    override fun getViewId() = R.layout.page_on_boarding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                if (checkToPage(position)) {
                    btn_go.text = getString(R.string.next_on_board)
                } else {
                    btn_go.text = getString(R.string.skip)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        btn_go.setOnClickListener {
            if (checkToPage(vp_page.currentItem)) {
                PreferenceHelper.setIsFirstLaunch()
                findNavController().navigate(R.id.main_on_boarding_fragment)
            } else {
                vp_page.currentItem += 1
            }
        }
    }

    private fun checkToPage(position: Int) = position == list.size - 1

    private fun setupViewPager() {
        val adapterl = OnBoardingAdapter(childFragmentManager)
        vp_page.adapter = adapterl
        list.add(
            OnBoardingFragment.getInstance(
                DataOnBoard(
                    R.drawable.thir,
                    getString(R.string.first_text_in_onboard)
                )
            )
        )
        list.add(
            OnBoardingFragment.getInstance(
                DataOnBoard(
                    R.drawable.se,
                    getString(R.string.second_text_in_onboard)
                )
            )
        )
        list.add(
            OnBoardingFragment.getInstance(
                DataOnBoard(
                    R.drawable.first_onb,
                    getString(R.string.third_text_in_onboard)
                )
            )
        )
        adapterl.update(list)
        slide.setupWithViewPager(vp_page)
    }
}