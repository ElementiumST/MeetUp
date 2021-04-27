package com.example.together.features.utils

import android.content.Context
import com.example.together.data.testRetrofit.di.TestApiModule
import com.example.together.data.testRetrofit.travels.TravelsRepository
import com.example.together.data.testRetrofit.travels.api.TravelsApi
import com.example.together.data.testRetrofit.user.api.ProfileApi
import com.example.together.data.testRetrofit.user.repos.UserProfileRepository
import com.example.together.features.splash.SplashActivity
import dagger.Component
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Component(modules = [AppModule::class, RetrofitModule::class, RepositoryModule::class, ApiModule::class])
@Singleton
interface AppComponent {
    fun inject(splashActivity: SplashActivity)

    fun provideContext(): Context

    fun provideRetrofit(): Retrofit

    fun provideProfileApi(): ProfileApi

    fun provideUserProfileRepository(): UserProfileRepository

    fun provideTravelsApi(): TravelsApi

    fun provideTravelsRepository(): TravelsRepository

}