package com.example.simpleapp.view.ViewCallBack

import io.reactivex.disposables.Disposable

interface ViewSubscribedListener {
    fun addDisposable(d: Disposable)
}