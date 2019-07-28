package com.example.simpleapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.simpleapp.model.entity.MovieInfo

class MovieViewModel(private val movie: MovieInfo) : ViewModel() {

    fun getTitle(): String? {
        return movie.title
    }

    fun getRating(): String? {
        return movie.popularity
    }

    fun getReleaseDate(): String? {
        return movie.release_date
    }

    fun getImageUrl(): String {
        return movie.poster_path
    }

}