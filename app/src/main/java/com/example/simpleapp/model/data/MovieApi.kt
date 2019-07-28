package com.example.simpleapp.model.data


import com.example.simpleapp.model.entity.MovieInfo
import com.example.simpleapp.model.entity.PopularResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieApi {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/movie/"
        const val IMAGE_URL_BASE = "https://image.tmdb.org/t/p/w500"
        const val API_KEY = "c06e14cd13b2c6373fdc8f9f3dd47eb3"
        fun getImageUrl(urlPath:String):String{
            return IMAGE_URL_BASE + urlPath
        }
    }

    @GET("popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Observable<PopularResponse<List<MovieInfo>>>
}
