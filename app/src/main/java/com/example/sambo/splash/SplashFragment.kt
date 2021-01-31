package com.example.sambo.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.sambo.R
import com.example.sambo.ui.fragment.BaseFragment
import com.example.sambo.ui.main.MainActivity

class SplashFragment : BaseFragment() {

    override fun getViewId() = R.layout.fragment_splash

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({
            selectFragment()
        }, 3000)
    }

    private fun selectFragment() {
        if (PreferenceHelper.getIsFirstLaunch()) {
            findNavController().navigate(R.id.splashFragment)
        } else {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}