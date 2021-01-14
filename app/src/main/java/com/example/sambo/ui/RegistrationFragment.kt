package com.example.sambo.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sambo.R
import kotlinx.android.synthetic.main.fragment_registration.*

class RegistrationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration_two, container, false)
        setupListeners()
    }


    private fun setupListeners() {
        btn_regis.setOnClickListener {
            findNavController().navigate(R.id.main_on_boarding_fragment)


        }
        btn_login.setOnClickListener {
            val intent = Intent(activity, RegistrationTwoFragment::class.java)
            startActivity(intent)

        }
    }


}
