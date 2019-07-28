package com.example.simpleapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simpleapp.R
import com.example.simpleapp.view.Fragment.MovieFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(
            R.id.movie_fragment,
            MovieFragment.instance
        ).commit()
    }

}