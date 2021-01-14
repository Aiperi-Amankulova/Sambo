package com.example.sambo.ui.fragment.profile_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sambo.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragmenet_bottom_sheat.*

class BottomSheetFragment(
    private val listener: (type: UserPhotoType) -> Unit) : BottomSheetDialogFragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragmenet_bottom_sheat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openCamera.setOnClickListener {
            listener.invoke(UserPhotoType.CAMERA)
        }
        openGallery.setOnClickListener {
            listener.invoke(UserPhotoType.GALLERY)
        }
    }
}