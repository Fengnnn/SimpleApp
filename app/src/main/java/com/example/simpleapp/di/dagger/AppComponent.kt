package com.example.simpleapp.di.dagger

import com.example.simpleapp.viewModel.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    RetrofitModule::class
    ])
interface AppComponent {
    fun inject(target:MainViewModel)
}