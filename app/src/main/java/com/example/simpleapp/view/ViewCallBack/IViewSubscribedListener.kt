package com.example.simpleapp.view.ViewCallBack

import io.reactivex.disposables.Disposable

interface IViewSubscribedListener {
    fun addDisposable(d: Disposable)
}