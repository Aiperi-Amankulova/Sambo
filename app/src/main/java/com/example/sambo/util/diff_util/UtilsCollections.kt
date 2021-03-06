package com.example.sambo.util.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.example.sambo.data.model.home_collections.RowsItem


object UtilsCollections {

    val diffUtilCollections = object: DiffUtil.ItemCallback<RowsItem>(){
        override fun areItemsTheSame(oldItem: RowsItem, newItem: RowsItem): Boolean {
            return oldItem.created_at == newItem.created_at
                    && oldItem.icon  == newItem.icon
                    && oldItem.id== newItem.id
                    && oldItem.rank  == newItem.rank
                    && oldItem.title == newItem.title
                    && oldItem.updated_at == newItem.updated_at
        }

        override fun areContentsTheSame(oldItem: RowsItem, newItem: RowsItem): Boolean {
            return oldItem == newItem
        }
    }
}