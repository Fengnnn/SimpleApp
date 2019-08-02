package com.example.simpleapp.view.Fragment

import androidx.fragment.app.Fragment
import com.example.simpleapp.view.ViewCallBack.IViewSubscribedListener
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.CompositeDisposable

abstract  class BaseFragment: Fragment(),IViewSubscribedListener {
    private var disposable = CompositeDisposable()
    override fun addDisposable(d: Disposable){
        this.disposable.add(d)
    }
    override fun onDestroy() {
        super.onDestroy()
        this.disposable.clear()
    }

}