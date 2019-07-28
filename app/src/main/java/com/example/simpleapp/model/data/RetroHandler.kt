package com.example.simpleapp.model.data

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.example.simpleapp.model.entity.MovieInfo
import com.example.simpleapp.model.entity.PopularResponse
import io.reactivex.Observable
import io.reactivex.Observer
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetroHandler {

    private val DEFAULT_TIMEOUT = 10
       private var retrofit: Retrofit
     private var movieApi: MovieApi
     private var builder: OkHttpClient.Builder

    private object Singleton {
         val INSTANCE = RetroHandler()
    }


    fun getInstance(): RetroHandler {
        return Singleton.INSTANCE
    }

     init {
        builder = OkHttpClient.Builder()
        builder.connectTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
        retrofit = Retrofit.Builder()
            .client(builder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(MovieApi.BASE_URL)
            .build()
        movieApi = retrofit.create(MovieApi::class.java)
    }

    fun getMovies(observer: Observer<MovieInfo>) {
        movieApi.getPopularMovies(MovieApi.API_KEY).
            map { popularResponse: PopularResponse<List<MovieInfo>> ->
                 popularResponse.results
            }.flatMap { results: List<MovieInfo> ->
                Observable.fromIterable(results)
            }.subscribeOn(Schedulers.io()
        ).observeOn(AndroidSchedulers.mainThread()
        ).subscribe(observer)
    }
}