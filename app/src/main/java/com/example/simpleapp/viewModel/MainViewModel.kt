package com.example.simpleapp.viewModel

import androidx.databinding.ObservableField
import com.example.simpleapp.view.ViewCallBack.ICompletedListener
import android.view.View
import com.example.simpleapp.di.dagger.DaggerAppComponent
import com.example.simpleapp.model.entity.MovieInfo
import com.example.simpleapp.view.Adapter.MovieAdapter
import com.example.simpleapp.view.ViewCallBack.IViewSubscribedListener
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject


class MainViewModel(
    private val movieAdapter: MovieAdapter,
    private val completedListener: ICompletedListener,
    private val viewSubscribedListener: IViewSubscribedListener
) {
    lateinit var contentViewVisibility: ObservableField<Int>
    lateinit var progressBarVisibility: ObservableField<Int>
    lateinit var errorInfoLayoutVisibility: ObservableField<Int>
    lateinit var exception: ObservableField<String>
    @Inject
    lateinit var  movieObservable: Observable<MovieInfo>
    init {
       DaggerAppComponent.builder().build().inject(this)
        initData()
        getMovies(getMovieObserver())
    }

    /**
     * set up subscriber and trigger api call to fetch popular move info
     */
    private fun getMovies(movieObserver: Observer<MovieInfo>) {
        movieObservable.subscribe(movieObserver)
    }

    private fun getMovieObserver(): Observer<MovieInfo> {
        return object : BaseObserver<MovieInfo>() {
            override fun onNext(t: MovieInfo) {
                movieAdapter.addItem(t)
            }
        }
    }

    fun refreshData() {
        getMovies(getMovieObserver())
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
