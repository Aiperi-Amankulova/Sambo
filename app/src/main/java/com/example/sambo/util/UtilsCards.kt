package com.example.sambo.util

import androidx.recyclerview.widget.DiffUtil
import com.example.sambo.data.model.home_cards.RowsItem

object UtilsCards {

    val diffUtilCards = object: DiffUtil.ItemCallback<RowsItem>(){
        override fun areItemsTheSame(oldItem: RowsItem, newItem: RowsItem): Boolean {
            return oldItem.comments_count == newItem.comments_count
                    && oldItem.content  == newItem.content
                    && oldItem.created_at == newItem.created_at
                    && oldItem.description== newItem.description
                    && oldItem.document  == newItem.document
                    && oldItem.id == newItem.id
                    && oldItem.material_type == newItem.material_type
                    && oldItem.preview == newItem.preview
                    && oldItem.rank == newItem.rank
                    && oldItem.text == newItem.text
                    && oldItem.updated_at == newItem.updated_at
        }

        override fun areContentsTheSame(oldItem: RowsItem, newItem: RowsItem): Boolean {
            return oldItem == newItem
        }
    }
}