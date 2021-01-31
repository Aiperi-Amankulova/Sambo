package com.example.sambo.ui.on_boarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.sambo.R
import com.example.sambo.data.model.cammon.BaseFragment
import com.example.sambo.data.model.home_cards.RowsItem
import com.example.sambo.splash.PreferenceHelper
import kotlinx.android.synthetic.main.page_on_boarding.*

class OnBoardingGeneralFragment(override val it: RowsItem) : BaseFragment() {

    private val list = arrayListOf<Fragment>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
        setupListeners()
    }

    override fun resID() = R.layout.page_on_boarding


    private fun setupListeners() {
        vp_page.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (isLastPage(position)) {
                    btn_go.text = getString(R.string.next_on_board)
                } else {
                    btn_go.text = getString(R.string.skip)
                }
            }

        })

        btn_go.setOnClickListener {
            if (isLastPage(vp_page.currentItem)) {
                PreferenceHelper.setIsFirstLaunch()
                findNavController().navigate(R.id.action_onBoardMainFragment_to_registrationOneFragment)
            }
            else {
                vp_page.currentItem += 1
            }
        }
    }

    private fun isLastPage(position: Int) = position == list.size - 1


    private fun setupViewPager() {
        val adapter = OnBoardingAdapter(childFragmentManager)
        vp_page.adapter = adapter
        list.add( OnBoardingFragment.getInstance( OnBoardingModal(getString(R.string.first_text_in_onboard), R.drawable.thir)))
        list.add( OnBoardingFragment.getInstance( OnBoardingModal(getString(R.string.second_text_in_onboard), R.drawable.se)))
        list.add( OnBoardingFragment.getInstance( OnBoardingModal(getString(R.string.third_text_in_onboard), R.drawable.first_onb)))

        adapter.update(list)
        slide.setupWithViewPager(vp_page)
    }
}