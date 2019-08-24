package com.example.simpleapp.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class Movie(
    val vote_count: String,
    @PrimaryKey
    val id: String,
    val vote_average: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "popularity")
    val popularity: String,
    @ColumnInfo(name = "poster_path")
    val poster_path: String,
    val original_language: String,
    val original_title: String,
    val genre_ids: List<Int>,
    val backdrop_path: String,
    val adult: Boolean,
    @ColumnInfo(name = "overview")
    val overview: String,
    @ColumnInfo(name = "release_date")
    val release_date: String,
    val video: Boolean
)
