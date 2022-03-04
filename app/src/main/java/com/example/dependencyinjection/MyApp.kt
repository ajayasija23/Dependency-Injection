package com.example.dependencyinjection

import android.app.Application
import com.example.dependencyinjection.container.AppContainer

class MyApp:Application() {

    lateinit var appContainer:AppContainer
    override fun onCreate() {
        super.onCreate()
        appContainer=AppContainer()
    }
}