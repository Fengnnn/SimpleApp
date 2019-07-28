package com.example.simpleapp.di.dagger

import com.example.simpleapp.model.data.IMovieApiService
import com.example.simpleapp.model.data.retrofit.BaseRetrofitBuilder
import com.example.simpleapp.model.data.retrofit.MovieRetrofitService
import com.example.simpleapp.model.data.retrofit.TMDbObservableBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideBaseRetrofitBuilder() = BaseRetrofitBuilder()
    @Provides
    @Singleton
    fun provideMovieApiService(baseRetrofitBuilder: BaseRetrofitBuilder) = MovieRetrofitService(baseRetrofitBuilder).buildMovieService()
    @Provides
    @Singleton
    fun provideMovieObservable(movieApiService: IMovieApiService)= TMDbObservableBuilder(movieApiService).getMoviesObservable()
}

