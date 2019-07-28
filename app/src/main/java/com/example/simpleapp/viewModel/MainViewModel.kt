package com.example.simpleapp.viewModel

import androidx.databinding.ObservableField
import com.example.simpleapp.view.ViewCallBack.CompletedListener
import android.view.View
import com.example.simpleapp.model.data.retrofit.RetroHandler
import com.example.simpleapp.model.entity.MovieInfo
import com.example.simpleapp.view.Adapter.MovieAdapter
import com.example.simpleapp.view.ViewCallBack.ViewSubscribedListener
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class MainViewModel(
    private val movieAdapter: MovieAdapter,
    private val completedListener: CompletedListener,
    private val viewSubscribedListener: ViewSubscribedListener
) {
    lateinit var contentViewVisibility: ObservableField<Int>
    lateinit var progressBarVisibility: ObservableField<Int>
    lateinit var errorInfoLayoutVisibility: ObservableField<Int>
    lateinit var exception: ObservableField<String>

    init {
        initData()
        getMovies()
    }

    /**
     * set up subscriber and trigger api call to fetch popular move info
     */
    private fun getMovies() {
        val observable = RetroHandler.getMoviesObservable()
        observable.subscribe(getMovieSubscriber())
    }

    private fun getMovieSubscriber(): Observer<MovieInfo> {
        return object : BaseObserver<MovieInfo>() {
            override fun onNext(t: MovieInfo) {
                movieAdapter.addItem(t)
            }
        }
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

    abstract inner class BaseObserver<T> : Observer<T> {
        override fun onComplete() {
            hideAll()
            contentViewVisibility.set(View.VISIBLE)
            completedListener.onCompleted()
        }

        override fun onSubscribe(d: Disposable) {
            viewSubscribedListener.addDisposable(d)
        }

        override fun onError(e: Throwable) {
            hideAll()
            errorInfoLayoutVisibility.set(View.VISIBLE)
            exception.set(e.message)
        }
    }


}
