package com.example.sambo.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sambo.R
import com.example.sambo.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_registration_two.*

class RegistrationTwoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_sam.setOnClickListener {
            startActivity(
                Intent(
                    requireContext(),
                    MainActivity::class.java
                )
            )
        }
        btn_trener.setOnClickListener {
            startActivity(
                Intent(
                    requireContext(),
                    MainActivity::class.java
                )
            )
        }
        btn_parent.setOnClickListener {
            startActivity(
                Intent(
                    requireContext(),
                    MainActivity::class.java
                )
            )
        }
    }
}