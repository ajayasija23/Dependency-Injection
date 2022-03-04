package com.example.dependencyinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.dependencyinjection.adapter.NewsAdapter
import com.example.dependencyinjection.databinding.ActivityMainBinding
import com.example.dependencyinjection.viewModels.NewsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel:NewsViewModel by viewModels()
    val apiKey="8b13262fb2ad4bbb93afcc3270f08c28"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val appContainer=(application as MyApp).appContainer
        viewModel.init(appContainer.repository)
        viewModel.getHeadLines("in",apiKey)
        bindObservers()
    }

    private fun bindObservers() {
        viewModel.newsLiveData.observe(this){
            binding.rvNews.adapter=NewsAdapter(this,it.articles)
        }
        viewModel.error.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}