package com.example.sambo.ui.fragment.profile_fragment

import android.content.DialogInterface
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.sambo.R
import com.example.sambo.data.model.cammon.PhotoFragment
import com.example.sambo.data.model.cammon.pickPhotoFromGalleryWithPermissionCheck
import com.example.sambo.data.model.cammon.shootPhotoWithPermissionCheck
import com.example.sambo.data.model.home_cards.RowsItem
import com.example.sambo.splash.PreferenceHelper
import com.example.sambo.ui.FragmentActivity
import com.example.sambo.util.ext.cleanLaunchActivity
import com.google.android.material.shape.CornerFamily
import kotlinx.android.synthetic.main.fragment_profile.*
import java.io.File

class ProfileFragment(override val it: RowsItem) : PhotoFragment() {

    override fun resID() = R.layout.fragment_profile

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        makeRoundImage()
    }

    private fun setupListeners() {
        tv_edit.setOnClickListener {
            alertDialog()
        }

        btn_exit.setOnClickListener {
            PreferenceHelper.clear()
            cleanLaunchActivity<FragmentActivity>()
        }
    }

    override fun showPhoto(file: File) {
        val bitmap = BitmapFactory.decodeFile(file.absolutePath)
        user_img.setImageBitmap(bitmap)
    }

    private fun makeRoundImage() {
        val radius = resources.getDimension(R.dimen.img_radius)
        val shape = user_img.shapeAppearanceModel.toBuilder()
            .setTopLeftCorner(CornerFamily.ROUNDED, radius)
            .setTopRightCorner(CornerFamily.ROUNDED, radius)
            .setBottomLeftCorner(CornerFamily.ROUNDED, radius)
            .setBottomRightCorner(CornerFamily.ROUNDED, radius)

            .build()

        user_img.shapeAppearanceModel = shape
    }

    private fun alertDialog() {
        val dialog = AlertDialog.Builder(
            android.view.ContextThemeWrapper(
                requireContext(),
                R.style.profile
            )
        )
        dialog.setTitle("Выбор загрузки фото")
        dialog.setPositiveButton("камера", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                shootPhotoWithPermissionCheck()
            }
        })

        dialog.setNegativeButton("галерея", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                pickPhotoFromGalleryWithPermissionCheck()
            }
        })
        dialog.show()
    }
}
