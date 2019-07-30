package com.example.simpleapp.view.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.simpleapp.R
import com.example.simpleapp.databinding.MovieFragmentBinding
import com.example.simpleapp.di.dagger.AppComponent
import com.example.simpleapp.di.dagger.DaggerAppComponent
import com.example.simpleapp.di.dagger.FragmentViewModel
import com.example.simpleapp.view.Adapter.MovieAdapter
import com.example.simpleapp.view.ViewCallBack.ICompletedListener
import com.example.simpleapp.viewModel.MainViewModel
import javax.inject.Inject

class MovieFragment : BaseFragment(), ICompletedListener, SwipeRefreshLayout.OnRefreshListener {
    @Inject
    lateinit var movieFragmentBinding: MovieFragmentBinding
    @Inject
    lateinit var movieAdapter: MovieAdapter
    lateinit var fragmentActions: FragmentActions

    companion object {
        val instance: MovieFragment
            get() = MovieFragment()
    }

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val contentView = inflater.inflate(R.layout.movie_fragment, container, false)
        val appComponent = DaggerAppComponent.builder().fragmentViewModel(FragmentViewModel(this, contentView)).build()
        appComponent.inject(this)
        initData(appComponent)
        return contentView
    }


    private fun initData(appComponent: AppComponent) {

        val viewModel: MainViewModel = appComponent.getMainViewModel()
        fragmentActions = appComponent.getFragmentActions()
        movieFragmentBinding.viewModel = viewModel
        this.initRecyclerView()
        fragmentActions.refreshData()

    }

    @SuppressLint("WrongConstant")
    fun initRecyclerView() {
        movieFragmentBinding.swipeRefreshLayout.setOnRefreshListener(this)
        movieFragmentBinding.recyclerView.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false
        )
        movieFragmentBinding.recyclerView.itemAnimator = DefaultItemAnimator()
        movieFragmentBinding.recyclerView.adapter = movieAdapter
    }

    override fun onRefresh() {
        movieAdapter.clearItems()
        fragmentActions.refreshData()
    }

    override fun onCompleted() {
        if (movieFragmentBinding.swipeRefreshLayout.isRefreshing) {
            movieFragmentBinding.swipeRefreshLayout.isRefreshing = false
        }
    }
}
