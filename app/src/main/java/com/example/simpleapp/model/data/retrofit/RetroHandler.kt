package com.example.simpleapp.model.data.retrofit

import com.example.simpleapp.model.data.MovieApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.example.simpleapp.model.entity.MovieInfo
import com.example.simpleapp.model.entity.PopularResponse
import io.reactivex.Observable

class RetroHandler {
    companion object {
        fun getMoviesObservable(): Observable<MovieInfo> {
            val retrofitBuilder = BaseRetrofitBuilder().getBaseBuilder(MovieApi.BASE_URL)
            val movieApi = retrofitBuilder.build().create(MovieApi::class.java)
            return movieApi.getPopularMovies(MovieApi.API_KEY)
                .map { popularResponse: PopularResponse<List<MovieInfo>> ->
                    popularResponse.results
                }.flatMap { results: List<MovieInfo> ->
                    Observable.fromIterable(results)
                }.subscribeOn(
                    Schedulers.io()
                ).observeOn(AndroidSchedulers.mainThread())
        }
    }
}