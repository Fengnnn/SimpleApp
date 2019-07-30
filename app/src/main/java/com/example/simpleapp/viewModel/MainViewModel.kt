package com.example.simpleapp.viewModel

import android.view.View
import androidx.databinding.ObservableField


class MainViewModel : IMainViewModel {
    override lateinit var contentViewVisibility: ObservableField<Int>
    override lateinit var progressBarVisibility: ObservableField<Int>
    override lateinit var errorInfoLayoutVisibility: ObservableField<Int>
    override lateinit var exception: ObservableField<String>

    init {
        initData()
    }

    private fun initData() {
        contentViewVisibility = ObservableField()
        progressBarVisibility = ObservableField()
        errorInfoLayoutVisibility = ObservableField()
        exception = ObservableField()
        contentViewVisibility.set(View.GONE)
        errorInfoLayoutVisibility.set(View.GONE)
        progressBarVisibility.set(View.VISIBLE)
    }

    override fun hideAll() {
        contentViewVisibility.set(View.GONE)
        errorInfoLayoutVisibility.set(View.GONE)
        progressBarVisibility.set(View.GONE)
    }
}
