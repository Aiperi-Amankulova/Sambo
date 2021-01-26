package com.example.sambo.data.model.home_courses


data class CoursesModel<T>(
    val rows: List<T>,
    val total_count: Int
)