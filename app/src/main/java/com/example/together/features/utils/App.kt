package com.example.together.features.utils

import android.app.Application
import androidx.activity.ComponentActivity
import androidx.annotation.MainThread
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import com.example.together.features.home.ui.profile.ProfileViewModel
import com.vk.api.sdk.VK

class App: Application() {
    companion object {
        lateinit var instance: App
        lateinit var appComponent: AppComponent
    }
    fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .retrofitModule(RetrofitModule())
            .build()
    }
    override fun onCreate() {
        super.onCreate()
        initializeDagger()
        instance = this
        VK.initialize(this)
    }
}

