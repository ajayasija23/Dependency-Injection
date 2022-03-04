package com.example.dependencyinjection.container

import com.example.dependencyinjection.network.Repository
import com.example.dependencyinjection.network.RetrofitClient

class AppContainer {
    private val apiService=RetrofitClient.apiService
    val repository=Repository(apiService)
}