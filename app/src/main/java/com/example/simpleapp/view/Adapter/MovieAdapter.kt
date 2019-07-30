package com.example.simpleapp.view.Adapter

import com.example.simpleapp.viewModel.MovieViewModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.*

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.simpleapp.R
import com.example.simpleapp.databinding.MovieItemBinding
import com.example.simpleapp.model.entity.MovieInfo


class MovieAdapter: BaseAdapter<MovieInfo>() {
    private val movies: MutableList<MovieInfo>

    init {
        movies = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val itemBinding: MovieItemBinding = inflate(
            LayoutInflater.from(parent.context)
            , R.layout.movie_item, parent
            , false
        )
        return BindingHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val movieViewModel = MovieViewModel(movies[position])
        holder.itemBinding.viewModel = movieViewModel
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun addItem(movie: MovieInfo) {
        movies.add(movie)
        notifyItemInserted(movies.size - 1)
    }

    fun clearItems() {
        movies.clear()
        notifyDataSetChanged()
    }

    class BindingHolder(val itemBinding: MovieItemBinding) : ViewHolder(itemBinding.cardView as View)
}