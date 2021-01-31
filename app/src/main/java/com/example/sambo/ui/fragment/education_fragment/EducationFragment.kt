package com.example.sambo.ui.fragment.education_fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.sambo.R
import com.example.sambo.data.model.bottom_sheet.BottomSheetRows
import com.example.sambo.ui.fragment.BaseFragment
import com.example.sambo.ui.fragment.education_fragment.bottomsheet.BottomSheet
import kotlinx.android.synthetic.main.fragment_education.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class EducationFragment:  BaseFragment() {

    override fun getViewId() = R.layout.fragment_education
    private val vm by sharedViewModel<EducationViewModel>()
    private val adapter = EducationAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.loadList()

        recyclerview_education.adapter = adapter
        vm.data.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        img_spinner.setOnClickListener {
            val bottomSheet = BottomSheet()
            bottomSheet.show(childFragmentManager,"tdsg")
        }
    }

//    override fun itemsClick(item: BottomSheetRows) {
//
//    }
}