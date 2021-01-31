package com.example.sambo.ui.fragment.home_fragment.collection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sambo.R
import com.example.sambo.data.model.home_collections.RowsItem
import com.example.sambo.util.diff_util.UtilsCollections
import com.example.sambo.util.ext.setCornerRadius
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_home_card.view.*
import kotlinx.android.synthetic.main.item_home_card.view.tv_title
import kotlinx.android.synthetic.main.item_home_collections.view.*

class CollectionsAdapter(private val listener: (item: RowsItem) -> Unit) :
    ListAdapter<RowsItem, CollectionsViewHolder>(
        UtilsCollections.diffUtilCollections
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_collections, parent, false)
        return CollectionsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollectionsViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }
}

class CollectionsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: RowsItem?, listener: (item: RowsItem) -> Unit) {
        itemView.tv_title.text = item?.title.toString()
        itemView.general_card.setOnClickListener {
            item?.let { it1 -> listener.invoke(it1) }
        }
        Picasso.get()
            .load(item?.icon)
            .placeholder(R.drawable.ic_logo)
            .error(R.drawable.ic_logo)
            .into(itemView.img_collections)

        val radius = itemView.resources.getDimension(R.dimen.img_radius)
        itemView.img_collections.setCornerRadius(
            topLeft = radius,
            topRight = radius,
            bottomLeft = radius,
            bottomRight = radius
        )
    }
}