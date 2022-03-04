package com.example.dependencyinjection.network

import com.example.dependencyinjection.model.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country") country:String,
        @Query("apiKey") apiKey:String,
    ):Response<NewsModel>
}