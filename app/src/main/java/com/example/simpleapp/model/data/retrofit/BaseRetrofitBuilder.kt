package com.example.simpleapp.model.data.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class BaseRetrofitBuilder {
    fun getBaseBuilder(baseUrl: String, defaultTimeOut: Long = 20): Retrofit.Builder {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(defaultTimeOut, TimeUnit.SECONDS)
        return Retrofit.Builder()
            .client(builder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(baseUrl)
    }
}