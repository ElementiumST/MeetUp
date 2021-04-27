package com.example.together.features.utils

import android.app.Application
import android.content.Context
import com.example.together.data.testRetrofit.user.api.ProfileApi
import com.example.together.data.testRetrofit.user.repos.UserProfileRepository
import com.example.together.data.testRetrofit.user.repos.UserProfileRepositoryImpl
import com.example.together.features.home.ui.profile.di.ProfileScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {
    @Provides
    @Singleton
    fun provideContext() : Context = application
}