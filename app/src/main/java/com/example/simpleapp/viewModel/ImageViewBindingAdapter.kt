package com.example.simpleapp.viewModel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.simpleapp.R
import com.example.simpleapp.model.data.MovieApi

/**
 * Put the image bindingAdapter in a separate file to make it run as public static function
 * to avoid binding component has to be static error
 */
@BindingAdapter("bind:imageUrl")
    fun loadImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
            .load(MovieApi.getImageUrl(url))
            .placeholder(R.drawable.defaultcover)
            .error(R.drawable.defaultcover)
            .into(imageView)
    }





