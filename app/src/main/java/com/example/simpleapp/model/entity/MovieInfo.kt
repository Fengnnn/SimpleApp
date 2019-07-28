package com.example.simpleapp.model.entity


data class MovieInfo(
    val vote_count: String,
    val id: String,
    val vote_average: String,
    val title: String,
    val popularity: String,
    val poster_path: String,
    val original_language: String,
    val original_title: String,
    val genre_ids: List<Int>,
    val backdrop_path: String,
    val adult: Boolean,
    val overview: String,
    val release_date: String,
    val video: Boolean
)
