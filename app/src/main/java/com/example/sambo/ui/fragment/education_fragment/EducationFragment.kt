package com.example.sambo.ui.fragment.education_fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.sambo.R
import com.example.sambo.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_education.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class EducationFragment:  BaseFragment() {

    override fun getViewId() = R.layout.fragment_education
    private val vm by viewModel<EducationViewModel>()
    private val adapter = RecyclerviewAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vertical_rv.adapter = adapter

        vm.dataEducation.observe(viewLifecycleOwner, Observer {
            adapter.update(it)
        })
        setupSpinner()
    }

    private fun setupSpinner() {
        card_t.setOnClickListener {
            val btmEducation = BottomSheadEducationFragment(vm.dataEducation.value)
            btmEducation.show(childFragmentManager, "TAG")
        }
    }
}