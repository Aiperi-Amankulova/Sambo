package com.example.sambo.data.model.cammon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sambo.data.model.home_cards.RowsItem

abstract class BaseFragment : Fragment() {

    abstract val it: RowsItem

    protected abstract fun resID(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(resID(), container, false)
    }
}