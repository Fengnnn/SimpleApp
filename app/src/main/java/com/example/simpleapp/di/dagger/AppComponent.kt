package com.example.simpleapp.di.dagger

import com.example.simpleapp.view.Fragment.FragmentAction
import com.example.simpleapp.view.Fragment.MovieFragment
import com.example.simpleapp.viewModel.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RetrofitModule::class,
        FragmentViewModel::class
    ]
)
interface AppComponent {
    fun getMainViewModel(): MainViewModel
    fun getFragmentActions(): FragmentAction
    fun inject(target: MovieFragment)
}