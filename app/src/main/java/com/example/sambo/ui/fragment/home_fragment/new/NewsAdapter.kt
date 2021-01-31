package com.example.sambo.ui.fragment.home_fragment.new

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sambo.data.model.home_cards.RowsItem
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sambo.R
import com.example.sambo.util.diff_util.UtilsCards
import com.example.sambo.util.ext.setCornerRadius
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_home_news.view.*

class NewsAdapter(private val listener: () -> Unit) : ListAdapter<RowsItem, NewsViewHolder>(
        UtilsCards.diffUtilCards) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }
}

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: RowsItem?, listener: () -> Unit) {
        itemView.tv_news.text = item?.title.toString()
        itemView.news_layout.setOnClickListener {
            item?.let { it1 -> listener.invoke() }
        }
        Picasso.get()
                .load(item?.preview)
                .placeholder(R.drawable.ic_logo)
                .error(R.drawable.ic_logo)
                .into(itemView.img_news)

        val radius = itemView.resources.getDimension(R.dimen.img_new_radius)
        itemView.img_news.setCornerRadius(
                topLeft = radius,
                topRight = radius,
                bottomLeft = radius,
                bottomRight = radius
        )
    }
}
