package com.example.sambo.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sambo.R
import com.example.sambo.utils.CurseUtils
import com.example.sambo.utils.RowItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_curs.view.*
import kotlinx.android.synthetic.main.page_curs.view.*

class CurseAdapter : ListAdapter<RowItem, CardsViewHolder>(CurseUtils.diffUtilCards) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.page_curs,parent,false)
        return CardsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CardsViewHolder(view: View): RecyclerView.ViewHolder(view){
    fun bind(item: RowItem?) {
        itemView.tv_curs.text = item?.title.toString()

        Picasso.get().load(item?.preview).into(itemView.img_cloud)
    }
}