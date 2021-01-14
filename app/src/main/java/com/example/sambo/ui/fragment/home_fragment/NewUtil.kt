package com.example.sambo.ui.fragment.home_fragment

import androidx.recyclerview.widget.DiffUtil

object NewUtil {
    val newUtil = object: DiffUtil.ItemCallback<RowNew>(){
        override fun areItemsTheSame(oldItem: RowNew, newItem: RowNew): Boolean {
            return oldItem.comments_count == newItem.comments_count
                    && oldItem.content  == newItem.content
                    && oldItem.created_at == newItem.created_at
                    && oldItem.email== newItem.email
                    && oldItem.id == newItem.id
                    && oldItem.preview == newItem.preview
                    && oldItem.status_code == newItem.status_code
                    && oldItem.title == newItem.title
                    && oldItem.updated_at == newItem.updated_at
        }

        override fun areContentsTheSame(oldItem: RowNew, newItem: RowNew): Boolean {
            return oldItem == newItem
        }
    }
}
