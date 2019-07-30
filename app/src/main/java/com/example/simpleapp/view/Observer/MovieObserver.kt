package com.example.simpleapp.view.Observer

import com.example.simpleapp.model.entity.MovieInfo
import com.example.simpleapp.view.Adapter.IAdapter
import com.example.simpleapp.view.ViewCallBack.ICompletedListener
import com.example.simpleapp.view.ViewCallBack.IViewSubscribedListener
import com.example.simpleapp.viewModel.IMainViewModel
import com.example.simpleapp.viewModel.MainViewModel
import javax.inject.Inject

class MovieObserver @Inject constructor(
    mainViewModel: IMainViewModel,
    private val movieAdapter: IAdapter<MovieInfo>,
    completedListener: ICompletedListener,
    viewSubscribedListener: IViewSubscribedListener
) : BaseObserver<MovieInfo>(mainViewModel, completedListener, viewSubscribedListener) {
    override fun onNext(t: MovieInfo) {
        movieAdapter.addItem(t)
    }
}