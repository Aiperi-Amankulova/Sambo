package com.example.sambo.ui.fragment.education_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sambo.R
import com.example.sambo.data.model.RowsModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.item_spinner_competition.*

open class
BottomSheadEducationFragment(private val value: List<RowsModel>?) : BottomSheetDialogFragment() {
    private val adapter = RecyclerviewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.item_spinner_competition, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview_spinner.adapter = adapter

        adapter.update(value)

    }
}