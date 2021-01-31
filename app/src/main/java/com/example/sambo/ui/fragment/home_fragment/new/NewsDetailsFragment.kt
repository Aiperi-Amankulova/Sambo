package com.example.sambo.ui.fragment.home_fragment.new

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.sambo.R
import com.example.sambo.data.model.cammon.BaseFragment
import com.example.sambo.data.model.home_cards.RowsItem
import com.example.sambo.util.ext.setCornerRadius
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_news_details.*

class NewsDetailsFragment(override val it: RowsItem) : BaseFragment() {
    override fun resID() = R.layout.item_home_news

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupListeners()
    }

    private fun setupListeners() {
        btn_back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupViews() {
        val bundle = NewsDetailsFragmentArgs.fromBundle(requireArguments())

        tv_text.text = bundle.details?.title
        tv_for_detail.text = bundle.details?.content
        Picasso.get()
            .load(bundle.details?.preview)
            .placeholder(R.drawable.ic_logo)
            .error(R.drawable.ic_logo)
            .into(img_news_)

        val imageRadius = resources.getDimension(R.dimen.news)
        img_news_.setCornerRadius(
            bottomLeft = imageRadius,
            bottomRight = imageRadius
        )
    }
}