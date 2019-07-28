package com.example.simpleapp.model.data.retrofit

import com.example.simpleapp.model.data.IMovieApiService
import javax.inject.Inject

/**
 * build service for each base url
 */
class MovieRetrofitService @Inject constructor(private val baseRetrofitBuilder: BaseRetrofitBuilder){
     fun buildMovieService(): IMovieApiService {
        val retrofitBuilder = baseRetrofitBuilder.getBaseBuilder(IMovieApiService.MOVIE_BASE_URL)
       return retrofitBuilder.build().create(IMovieApiService::class.java)
    }

}