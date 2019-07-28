package com.example.simpleapp.viewModel.Observer

import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class BaseViewObserver<T> : Observer<T> {
    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable) {
    }

    override fun onComplete() {
    }
}