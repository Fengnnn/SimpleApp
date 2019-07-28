package com.example.simpleapp.model.data.retrofit

import com.example.simpleapp.model.data.IMovieApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.example.simpleapp.model.entity.MovieInfo
import com.example.simpleapp.model.entity.MoviesResponse
import io.reactivex.Observable
import javax.inject.Inject

/**
 * get observable for each api data fetch
 */
class TMDbObservableBuilder ( private val movieApiService: IMovieApiService) {
        fun getMoviesObservable(): Observable<MovieInfo> {
            return movieApiService.getMovies(IMovieApiService.API_KEY)
                .map { moviesResponse: MoviesResponse<List<MovieInfo>> ->
                    moviesResponse.results
                }.flatMap { results: List<MovieInfo> ->
                    Observable.fromIterable(results)
                }.subscribeOn(
                    Schedulers.io()
                ).observeOn(AndroidSchedulers.mainThread())
        }

}