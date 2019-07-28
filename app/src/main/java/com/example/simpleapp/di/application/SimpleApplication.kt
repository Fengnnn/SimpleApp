package com.example.simpleapp.di.application

import android.app.Application
import com.example.simpleapp.di.dagger.AppComponent
import com.example.simpleapp.di.dagger.DaggerAppComponent

class SimpleApplication : Application() {

    lateinit var simpleComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        simpleComponent = initDagger()
    }

    private fun initDagger(): AppComponent = DaggerAppComponent.builder().build()
}