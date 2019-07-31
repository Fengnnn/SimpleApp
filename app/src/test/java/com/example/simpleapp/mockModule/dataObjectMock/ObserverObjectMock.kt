package com.example.simpleapp.mockModule.dataObjectMock

import com.example.simpleapp.model.entity.MovieInfo
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class ObserverObjectMock<T> : Observer<T> {
    lateinit var errorMessage: String
    var resultList: MutableList<T> = ArrayList()
    var completed: Boolean = false
    var subScribed: Boolean = false
    override fun onSubscribe(d: Disposable) {
        subScribed = true
    }

    override fun onNext(t: T) {
        resultList.add(t)
    }
    override fun onError(e: Throwable) {
        errorMessage = e.message.toString()
    }

    override fun onComplete() {
        completed = true
    }

}