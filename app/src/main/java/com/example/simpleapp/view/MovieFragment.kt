package com.example.simpleapp.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.simpleapp.R
import com.example.simpleapp.databinding.MovieFragmentBinding
import com.example.simpleapp.view.Adapter.BaseAdapter
import com.example.simpleapp.view.Adapter.MovieAdapter
import com.example.simpleapp.view.Fragment.BaseFragment
import com.example.simpleapp.view.ViewCallBack.CompletedListener
import com.example.simpleapp.viewModel.MainViewModel

class MovieFragment : BaseFragment(), CompletedListener, SwipeRefreshLayout.OnRefreshListener {
    private lateinit var viewModel: MainViewModel
    private lateinit var movieFragmentBinding: MovieFragmentBinding
    private lateinit var movieAdapter: MovieAdapter

    companion object {
        val instance: MovieFragment
            get() = MovieFragment()
    }

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val contentView = inflater.inflate(R.layout.movie_fragment, container, false)
        movieFragmentBinding = MovieFragmentBinding.bind(contentView)
        initData()
        return contentView
    }


    private fun initData() {
        movieAdapter = MovieAdapter()
        this.initRecyclerView(movieAdapter)
        viewModel = MainViewModel(movieAdapter, this, this)
        movieFragmentBinding.viewModel = viewModel
        movieFragmentBinding.swipeRefreshLayout.setOnRefreshListener(this)
    }

    @SuppressLint("WrongConstant")
    fun initRecyclerView(adapter: BaseAdapter) {
        movieFragmentBinding.recyclerView.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false
        )
        movieFragmentBinding.recyclerView.itemAnimator = DefaultItemAnimator()
        movieFragmentBinding.recyclerView.adapter = adapter
    }

    override fun onRefresh() {
        movieAdapter.clearItems()
        viewModel.refreshData()
    }

    override fun onCompleted() {
        if (movieFragmentBinding.swipeRefreshLayout.isRefreshing) {
            movieFragmentBinding.swipeRefreshLayout.isRefreshing = false
        }
    }
}
