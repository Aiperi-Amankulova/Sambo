package com.example.sambo.ui.fragment.tip_fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.sambo.R
import com.example.sambo.data.model.cammon.BaseFragment
import kotlinx.android.synthetic.main.fragment_tip.*

abstract class TipFragment : BaseFragment() {
    override fun resID() = R.layout.fragment_tip

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {
        btn_go.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}