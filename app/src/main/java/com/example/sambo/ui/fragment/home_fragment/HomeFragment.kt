package com.example.sambo.ui.fragment.home_fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.sambo.R
import com.example.sambo.data.CurseAdapter
import com.example.sambo.ui.fragment.BaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment: BaseFragment() {

    override fun getViewId() = R.layout.fragment_home
    private val collectionsAdapter = CollectionsAdapter()
    private val vm by sharedViewModel<HomeViewModel>()
    private val curseAdapter = CurseAdapter()
    private val newsAdapter = NewAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.loadCards()
        vm.loadCollections()
        vm.loadNews()

        recyclerviewCards.adapter = curseAdapter
        recyclerviewCollections.adapter = collectionsAdapter
        recyclerviewNews.adapter = newsAdapter

        vm.cardsData.observe(viewLifecycleOwner, Observer {
            curseAdapter.submitList(it.rows)
        })

        vm.collectionsData.observe(viewLifecycleOwner, Observer {
            collectionsAdapter.submitList(it.rows)
        })

        vm.newsData.observe(viewLifecycleOwner, Observer {
            newsAdapter.submitList(it.rows)
        })
    }
}
