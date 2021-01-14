package com.example.sambo.ui.fragment.education_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sambo.R
import com.example.sambo.data.model.RowsModel
import kotlinx.android.synthetic.main.item_curs.view.*

class RecyclerviewAdapter() : RecyclerView.Adapter<ViewHolder>() {

    private val list = arrayListOf<RowsModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_curs, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = list.size

    fun update(list: List<RowsModel>?) {
        if (list != null) {
            this.list.clear()
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(point: RowsModel) {
        itemView.tv_curs.text = point.title
    }
}