package com.example.sambo.ui.fragment.education_fragment.bottomsheet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sambo.R
import com.example.sambo.data.model.bottom_sheet.BottomSheetRows
import kotlinx.android.synthetic.main.page_bottom_sheet.view.*

class BottomSheetAdapter(private val listener: ItemListener) :
    ListAdapter<BottomSheetRows, BottomViewHolder>(UtilBottom()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout. view_bottom_sheet, parent, false)
        return BottomViewHolder(view)
    }

    override fun onBindViewHolder(holder: BottomViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }
}

class UtilBottom : DiffUtil.ItemCallback<BottomSheetRows>() {
    override fun areItemsTheSame(oldItem: BottomSheetRows, newItem: BottomSheetRows): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: BottomSheetRows, newItem: BottomSheetRows): Boolean {
        return oldItem.text == newItem.text
    }

}

class BottomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(
        item: BottomSheetRows,
        listener: ItemListener
    ) {
        itemView.bottom_sheet.text = item.text
        itemView.setOnClickListener {
            listener.itemsClick(item)
        }
    }
}