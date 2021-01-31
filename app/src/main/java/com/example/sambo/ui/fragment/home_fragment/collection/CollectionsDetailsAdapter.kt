package com.example.sambo.ui.fragment.home_fragment.collection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sambo.R
import com.example.sambo.data.model.home_collections.RowsItem
import com.example.sambo.util.diff_util.UtilsCollections
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_home_card.view.*

class CollectionsDetailsAdapter: ListAdapter<RowsItem, CollectionsDetailsViewHolder>(
    UtilsCollections.diffUtilCollections) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionsDetailsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_card,parent,false)
        return CollectionsDetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollectionsDetailsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CollectionsDetailsViewHolder(view: View): RecyclerView.ViewHolder(view) {
    fun bind(item: RowsItem?) {
        itemView.tv_title.text = item?.title.toString()
        Picasso.get()
            .load(item?.icon)
            .placeholder(R.drawable.ic_logo)
            .error(R.drawable.ic_logo)
            .into(itemView.img_parent)
    }
}
