package com.example.sambo.ui.fragment.home_fragment.collection

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.sambo.R
import com.example.sambo.data.model.cammon.BaseFragment
import com.example.sambo.data.model.home_cards.RowsItem
import com.example.sambo.util.decorators.ItemOffsetDecoration
import kotlinx.android.synthetic.main.fragment_collections_details.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class CollectionsDetailsFragment(override val it: RowsItem) : BaseFragment() {
    override fun resID() = R.layout.item_home_collections
    private val vm by sharedViewModel<CollectionsDetailsViewModel>()
    private val collectionsDetailsAdapter by lazy { CollectionsDetailsAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupListeners()
        setupRecyclerView()
        setupViewModel()
    }

    private fun setupViewModel() {
        vm.collectionsData.observe(viewLifecycleOwner, Observer {
            collectionsDetailsAdapter.submitList(it.rows)
        })
    }

    private fun setupRecyclerView() {
        recyclerview_details.adapter = collectionsDetailsAdapter

        recyclerview_details.addItemDecoration(
            ItemOffsetDecoration(
                itemBottomMargin = 20f
            )
        )
    }

    private fun setupListeners() {
        btn_back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupViews() {
        val bundle = CollectionsDetailsFragmentArgs.fromBundle(requireArguments())
        tvCollectionsTitle.text = bundle.collections?.title

        val categoryId = bundle.collections?.id
        categoryId.let {
            if (it != null) {
                vm.loadSelectionsData(it)
            }
        }
    }
}