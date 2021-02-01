package com.example.sambo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.sambo.R

class FragmentActivity: AppCompatActivity() {

    private var host : NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        host = Navigation.findNavController(this, R.id.nav_host_fragment_container)
    }
}