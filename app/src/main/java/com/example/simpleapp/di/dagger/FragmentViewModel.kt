package com.example.simpleapp.di.dagger

import android.view.View
import com.example.simpleapp.databinding.MovieFragmentBinding
import com.example.simpleapp.model.entity.MovieInfo
import com.example.simpleapp.view.Adapter.IAdapter
import com.example.simpleapp.view.Adapter.MovieAdapter
import com.example.simpleapp.view.Fragment.FragmentActions
import com.example.simpleapp.view.Fragment.MovieFragment
import com.example.simpleapp.view.Observer.MovieObserver
import com.example.simpleapp.view.ViewCallBack.ICompletedListener
import com.example.simpleapp.view.ViewCallBack.IViewSubscribedListener
import com.example.simpleapp.viewModel.MainViewModel
import com.example.simpleapp.viewModel.MovieViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import javax.inject.Singleton
import javax.security.auth.callback.Callback

@Module
class FragmentViewModel(private val movieFragment: MovieFragment,private val view: View) {
    @Provides
    @Singleton
    fun provideMovieFragmentBinding() = MovieFragmentBinding.bind(view)

    @Provides
    @Singleton
    fun provideMovieAdapter() = MovieAdapter()

    @Provides
    @Singleton
    fun provideMainViewModel() = MainViewModel()

    @Provides
    @Singleton
    fun provideMovieObserver(
        mainViewModel: MainViewModel,
        movieAdapter: MovieAdapter
    ) = MovieObserver(mainViewModel, movieAdapter, movieFragment, movieFragment)

    @Provides
    @Singleton
    fun provideFragmentAction(observable: Observable<MovieInfo>, observer: MovieObserver) =
        FragmentActions(observable, observer)
}