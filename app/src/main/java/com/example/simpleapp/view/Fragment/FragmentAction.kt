package com.example.simpleapp.view.Fragment

import com.example.simpleapp.model.entity.MovieInfo
import io.reactivex.Observable
import io.reactivex.Observer
import javax.inject.Inject

class FragmentAction @Inject constructor(
    private val movieObservable: Observable<MovieInfo>,
    private val movieObserver: Observer<MovieInfo>
) : IFragmentAction {
    override fun refreshData() {
        movieObservable.subscribe(movieObserver)
    }
}