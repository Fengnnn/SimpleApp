package com.example.simpleapp.view.Observer

import android.view.View
import com.example.simpleapp.view.ViewCallBack.ICompletedListener
import com.example.simpleapp.view.ViewCallBack.IViewSubscribedListener
import com.example.simpleapp.viewModel.IMainViewModel
import com.example.simpleapp.viewModel.MainViewModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

abstract class BaseObserver<T> (private  val mainViewModel: IMainViewModel,
                               private val completedListener: ICompletedListener,
                               private  val viewSubscribedListener: IViewSubscribedListener) : Observer<T> {

    override fun onComplete() {
        mainViewModel.hideAll()
        mainViewModel.contentViewVisibility.set(View.VISIBLE)
        completedListener.onCompleted()
    }

    override fun onSubscribe(d: Disposable) {
        viewSubscribedListener.addDisposable(d)
    }

    override fun onError(e: Throwable) {
        mainViewModel.hideAll()
        mainViewModel.errorInfoLayoutVisibility.set(View.VISIBLE)
        mainViewModel.exception.set(e.message)
    }


}