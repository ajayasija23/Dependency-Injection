package com.example.dependencyinjection.viewModels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dependencyinjection.model.NewsModel
import com.example.dependencyinjection.network.ApiService
import com.example.dependencyinjection.network.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel: ViewModel() {

    lateinit var repository:Repository
    val newsLiveData= MutableLiveData<NewsModel>()
    val error= MutableLiveData<String>()

    fun init(repository: Repository){
        this.repository=repository
    }

    fun getHeadLines(country:String,apiKey:String){
        viewModelScope.launch {
            try {
                val response=repository.getHeadlines(country,apiKey)
                withContext(Dispatchers.Main){
                    if (response.isSuccessful){
                        newsLiveData.value=response.body()
                    }else{
                        error.value=response.message()
                    }
                }
            } catch (e: Exception) {
                error.value=e.localizedMessage
            }
        }
    }
}