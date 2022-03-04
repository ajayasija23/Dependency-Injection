package com.example.dependencyinjection.network

import com.example.dependencyinjection.model.NewsModel
import retrofit2.Response

class Repository(val apiService: ApiService){
    suspend fun getHeadlines(country:String,apiKey:String):Response<NewsModel>{
        return apiService.getHeadlines(country, apiKey)
    }
}