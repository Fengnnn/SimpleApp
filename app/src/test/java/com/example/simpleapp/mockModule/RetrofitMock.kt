package com.example.simpleapp.mockModule

import com.example.simpleapp.mockModule.dataObjectMock.MovieResponseMock
import com.example.simpleapp.model.data.IMovieApiService
import com.example.simpleapp.model.entity.MovieInfo
import com.example.simpleapp.model.entity.MoviesResponse
import com.google.gson.JsonObject
import io.reactivex.Observable

class RetrofitMock(val mockResponse: String) {

    fun provideMovieObservable(): Observable<MovieInfo> {
        return MovieResponseMock(mockResponse).getMovieObservable()
    }

    fun provideResponseObservable(): Observable<MoviesResponse<List<MovieInfo>>> {
        return MovieResponseMock(mockResponse).getResponseObservable()
    }

    fun provideMovieApiService(): IMovieApiService {
        return object : IMovieApiService {
            override fun getMovies(apiKey: String): Observable<MoviesResponse<List<MovieInfo>>> {
                return provideResponseObservable()
            }

        }
    }


}