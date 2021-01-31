package com.example.sambo.ui.fragment.home_fragment.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sambo.R
import com.example.sambo.data.model.home_cards.RowsItem
import com.example.sambo.util.diff_util.UtilsCards
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_home_card.view.*

class CardsAdapter(private val listener: (item: RowsItem) -> Unit) :
    ListAdapter<RowsItem, CardsViewHolder>(UtilsCards.diffUtilCards) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_home_card, parent, false)
        return CardsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }
}

class CardsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: RowsItem?, listener: (item: RowsItem) -> Unit) {
        itemView.tv_title.text = item?.title.toString()
        itemView.card.setOnClickListener {
            item?.let { it1 -> listener.invoke(it1) }
        }
        Picasso.get()
            .load(item?.preview)
            .placeholder(R.drawable.ic_logo)
            .error(R.drawable.ic_logo)
            .into(itemView.img_parent)
    }
}