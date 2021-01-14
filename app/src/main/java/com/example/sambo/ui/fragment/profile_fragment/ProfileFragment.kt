package com.example.sambo.ui.fragment.profile_fragment

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sambo.R
import com.google.android.material.shape.CornerFamily
import kotlinx.android.synthetic.main.fragment_profile.*
import java.io.File

class ProfileFragment : BaseUserPhotoFragment() {

    private val bottomSheatDialog by lazy {
        BottomSheetFragment() {
            when (it) {
                UserPhotoType.GALLERY -> pickPhotoFromGalleryWithPermissionCheck()
                UserPhotoType.CAMERA -> shootPhotoWithPermissionCheck()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageCorners()
        setupListener()
    }

    private fun imageCorners() {
        val shape = user_img.shapeAppearanceModel.toBuilder()
            .setAllCorners(CornerFamily.ROUNDED, 120f)
            .build()
        user_img.shapeAppearanceModel = shape
    }

    private fun setupListener() {
        textView2.setOnClickListener {
            bottomSheatDialog.show(childFragmentManager, "TAG")
        }
    }

    override fun showPhoto(file: File) {
        val bitmap = BitmapFactory.decodeFile(file.absolutePath)
        user_img.setImageBitmap(bitmap)
    }
}