package com.example.simpleapp.viewModel

import androidx.databinding.ObservableField
import com.example.simpleapp.view.CompletedListener
import android.view.View
import com.example.simpleapp.model.data.RetroHandler
import com.example.simpleapp.model.entity.MovieInfo
import com.example.simpleapp.view.Adapter.MovieAdapter
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class MainViewModel(private val movieAdapter: MovieAdapter, private val completedListener: CompletedListener) {
    lateinit var contentViewVisibility: ObservableField<Int>
    lateinit var progressBarVisibility: ObservableField<Int>
    lateinit var errorInfoLayoutVisibility: ObservableField<Int>
    lateinit var exception: ObservableField<String>
     private var subscriber: Observer<MovieInfo>? = null

    init {
        initData()
        getMovies()
    }

    private fun getMovies() {
        subscriber= object : Observer<MovieInfo> {
            override fun onNext(t: MovieInfo) {
                movieAdapter.addItem(t)
            }

            override fun onComplete() {
                hideAll()
                contentViewVisibility.set(View.VISIBLE)
                completedListener.onCompleted()
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onError(e: Throwable) {
                hideAll()
                errorInfoLayoutVisibility.set(View.VISIBLE)
                exception.set(e.message)
            }
        }
        RetroHandler().getInstance().getMovies(subscriber as Observer<MovieInfo>)
    }

    fun refreshData() {
        getMovies()
    }

    private fun initData() {
        contentViewVisibility = ObservableField()
        progressBarVisibility = ObservableField()
        errorInfoLayoutVisibility = ObservableField()
        exception = ObservableField()
        contentViewVisibility.set(View.GONE)
        errorInfoLayoutVisibility.set(View.GONE)
        progressBarVisibility.set(View.VISIBLE)
    }

    private fun hideAll() {
        contentViewVisibility.set(View.GONE)
        errorInfoLayoutVisibility.set(View.GONE)
        progressBarVisibility.set(View.GONE)
    }
}
