package com.example.simpleapp.viewModel

import androidx.databinding.ObservableField

interface IMainViewModel {
    var contentViewVisibility: ObservableField<Int>
    var progressBarVisibility: ObservableField<Int>
    var errorInfoLayoutVisibility: ObservableField<Int>
    var exception: ObservableField<String>
    fun hideAll()
}