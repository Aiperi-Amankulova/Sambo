package com.example.sambo.ui.fragment.home_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sambo.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_news.view.*

class NewAdapter : ListAdapter<RowNew, VHNew>(NewUtil.newUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHNew {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return VHNew(view)
    }

    override fun onBindViewHolder(holder: VHNew, position: Int) {
        holder.bind(getItem(position))
    }
}

class VHNew(view: View): RecyclerView.ViewHolder(view){
    fun bind(item: RowNew) {
        itemView.tv_new.text = item?.title.toString()

        Picasso.get().load(item?.preview).into(itemView.img_new)
    }
}