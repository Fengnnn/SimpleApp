package com.example.simpleapp.model.data


import com.example.simpleapp.model.entity.MovieInfo
import com.example.simpleapp.model.entity.MoviesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface IMovieApiService {
    companion object {
        const val MOVIE_BASE_URL = "https://api.themoviedb.org/3/movie/"
        private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
        const val API_KEY = "c06e14cd13b2c6373fdc8f9f3dd47eb3"
        fun getImageUrl(urlPath: String): String {
            return this.IMAGE_BASE_URL + urlPath
        }
    }

    @GET("popular")
    fun getMovies(@Query("api_key") apiKey: String = API_KEY): Observable<MoviesResponse<List<MovieInfo>>>
}
