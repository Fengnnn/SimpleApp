package com.example.simpleapp.mockModule

import com.example.simpleapp.mockModule.dataObjectMock.ObserverObjectMock
import com.example.simpleapp.model.entity.MovieInfo
import com.example.simpleapp.view.Observer.BaseObserver
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class ViewModuleMock {

    fun provideMovieObserver(): ObserverObjectMock<MovieInfo> {
        return ObserverObjectMock()
    }
}