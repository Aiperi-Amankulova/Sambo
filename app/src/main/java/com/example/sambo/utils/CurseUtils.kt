package com.example.sambo.utils

import androidx.recyclerview.widget.DiffUtil

object CurseUtils {

    val diffUtilCards = object: DiffUtil.ItemCallback<RowItem>(){
        override fun areItemsTheSame(oldItem: RowItem, newItem: RowItem): Boolean {
            return oldItem.comments_count == newItem.comments_count
                    && oldItem.content  == newItem.content
                    && oldItem.created_at == newItem.created_at
                    && oldItem.description== newItem.description
                    && oldItem.document  == newItem.document
                    && oldItem.id == newItem.id
                    && oldItem.material_type == newItem.material_type
                    && oldItem.preview == newItem.preview
                    && oldItem.rank == newItem.rank
                    && oldItem.title == newItem.title
                    && oldItem.updated_at == newItem.updated_at
        }

        override fun areContentsTheSame(oldItem: RowItem, newItem: RowItem): Boolean {
            return oldItem == newItem
        }
    }
}