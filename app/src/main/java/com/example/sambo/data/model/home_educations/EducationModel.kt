package com.example.sambo.data.model.home_educations


data class EducationModel<T>(
    val rows: List<T>,
    val total_count: Int
)