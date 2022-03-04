package com.example.dependencyinjection.network

import com.example.dependencyinjection.BuildConfig
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    val baseUrl="https://newsapi.org/"
    val logger=HttpLoggingInterceptor().apply {
        level=HttpLoggingInterceptor.Level.BODY
    }

    val client=OkHttpClient.Builder()
        .addInterceptor(logger)
        .callTimeout(1,TimeUnit.MINUTES)
        .connectTimeout(1,TimeUnit.MINUTES)
        .writeTimeout(1,TimeUnit.MINUTES)
        .build()

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
    }
    val apiService:ApiService by lazy {
        getRetrofit().create(ApiService::class.java)
    }
}