package com.example.simpleapp.model.entity

data class PopularResponse<T>(
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: T
)
