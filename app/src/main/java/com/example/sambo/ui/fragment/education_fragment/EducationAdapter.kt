package com.example.sambo.ui.fragment.education_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sambo.R
import com.example.sambo.data.model.home_educations.RowsItem
import com.example.sambo.util.diff_util.UtilsEducation
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recyclerview_education.view.*

class EducationAdapter: PagedListAdapter<RowsItem, EducationVH>(UtilsEducation.diffUtilsCourses) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_education,parent,false)
        return EducationVH(view)
    }

    override fun onBindViewHolder(holder: EducationVH, position: Int) {
        holder.bind(getItem(position))
    }
}

class EducationVH(view: View):RecyclerView.ViewHolder(view){
    fun bind(item: RowsItem?) {
        itemView.tv_header.text = item?.title.toString()
        itemView.btn_education.text = item?.categories_list.toString()

        Picasso.get().load(item?.preview).into(itemView.img_education)
    }
}