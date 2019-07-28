package com.example.simpleapp.model.entity

data class MoviesResponse<T>(
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: T
)
