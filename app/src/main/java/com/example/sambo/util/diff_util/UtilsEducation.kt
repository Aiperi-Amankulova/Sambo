package com.example.sambo.util.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.example.sambo.data.model.home_educations.RowsItem

object UtilsEducation {
    val diffUtilsCourses = object: DiffUtil.ItemCallback<RowsItem>(){
        override fun areItemsTheSame(oldItem: RowsItem, newItem: RowsItem): Boolean {
            return oldItem.id == newItem.id
                    && oldItem.material_type  == newItem.material_type
                    && oldItem.title == newItem.title
                    && oldItem.description == newItem.description
                    && oldItem.content == newItem.content
                    && oldItem.rank== newItem.rank
                    && oldItem.duration  == newItem.duration
                    && oldItem.categories_list == newItem.categories_list
                    && oldItem.created_at == newItem.created_at
                    && oldItem.updated_at == newItem.updated_at
                    && oldItem.document == newItem.document
                    && oldItem.preview == newItem.preview
                    && oldItem.comments_count == newItem.comments_count
                    && oldItem.categories == newItem.categories
        }

        override fun areContentsTheSame(oldItem: RowsItem, newItem: RowsItem): Boolean {
            return oldItem == newItem
        }
    }
}