package com.example.sambo.ui.fragment.home_fragment

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.SnapHelper
import com.example.sambo.R
import com.example.sambo.data.model.cammon.BaseFragment
import com.example.sambo.data.model.home_cards.RowsItem
import com.example.sambo.ui.fragment.home_fragment.card.CardsAdapter
import com.example.sambo.ui.fragment.home_fragment.collection.CollectionsAdapter
import com.example.sambo.ui.fragment.home_fragment.new.NewsAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import com.example.sambo.util.decorators.GravitySnapHelper
import com.example.sambo.util.decorators.ItemOffsetDecoration


class HomeFragment(override val it: RowsItem) : BaseFragment() {

    override fun resID() = R.layout.fragment_home
    private val vm by sharedViewModel<HomeViewModel>()
    private val cardsAdapter by lazy { CardsAdapter() { navigateToCardsDetails(it) } }
    private val collectionsAdapter by lazy { CollectionsAdapter() {navigateToCollectionsDetails(it)} }
    private val newsAdapter by lazy { NewsAdapter() { navigateToCardsDetails(it) } }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupViewModel()
        setupListeners()

        vm.loadCards()
        vm.loadCollections()
        vm.loadNews()
    }

    private fun setupListeners() {
        btn_news.setOnClickListener {
            navigateToAdviceDetails()
        }
    }

    private fun setupRecyclerView() {
        recyclerview_home_horizontal.adapter = cardsAdapter
        recyclerview_collections.adapter = collectionsAdapter
        recyclerview_news.adapter = newsAdapter

        val helper: SnapHelper = GravitySnapHelper(Gravity.START)
        helper.attachToRecyclerView(recyclerview_home_horizontal)

        recyclerview_home_horizontal.addItemDecoration(
            ItemOffsetDecoration(
                itemLeftMargin = 10f,
                itemRightMargin = 10f,
                firstItemLeftMargin = 20f,
                lastItemRightMargin = 20f
            )
        )

        recyclerview_collections.addItemDecoration(
            ItemOffsetDecoration(
                itemLeftMargin = 8f,
                itemRightMargin = 8f,
                firstItemLeftMargin = 20f,
                lastItemRightMargin = 20f
            )
        )

        recyclerview_news.addItemDecoration(
            ItemOffsetDecoration(
                itemBottomMargin = 28f
            )
        )
    }

    private fun setupViewModel() {
        vm.cardsData.observe(viewLifecycleOwner, Observer {
            cardsAdapter.submitList(it.rows)
        })

        vm.collectionsData.observe(viewLifecycleOwner, Observer {
            collectionsAdapter.submitList(it.rows)
        })

        vm.newsData.observe(viewLifecycleOwner, Observer {
            newsAdapter.submitList(it.rows)
        })
    }

    private fun navigateToCardsDetails(data: RowsItem) {
        val destination = HomeDirections.actionHomeFragmentToNewsDetailsFragment(data)
        findNavController().navigate(destination)
    }

    private fun navigateToCollectionsDetails(data: com.example.sambo.data.model.home_collections.RowsItem) {
        val destination = HomeDirections.actionHomeFragmentToCollectionsDetailsFragment(data)
        findNavController().navigate(destination)
    }

    private fun navigateToAdviceDetails(){
        val destination = HomeDirections.actionHomeFragmentToAdviceDetailsFragment()
        findNavController().navigate(destination)
    }
}

private fun NewsAdapter.submitList(rows: List<com.example.sambo.data.model.home_news.RowsItem>) {


}
