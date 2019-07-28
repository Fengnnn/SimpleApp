package com.example.simpleapp.view.Fragment

import androidx.fragment.app.Fragment
import com.example.simpleapp.view.ViewCallBack.ViewSubscribedListener
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.CompositeDisposable

abstract  class BaseFragment: Fragment(),ViewSubscribedListener {
    private var composite = CompositeDisposable()
    override fun addDisposable(d: Disposable){
        this.composite.add(d)
    }
    override fun onDestroy() {
        super.onDestroy()
        this.composite.clear()
    }

}