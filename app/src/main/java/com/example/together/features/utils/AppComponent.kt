package com.example.together.features.utils

import android.content.Context
import com.example.together.data.api.friends.api.FriendsApi
import com.example.together.data.api.friends.repos.FriendsRepository
import com.example.together.data.api.newsLine.PostRepository
import com.example.together.data.api.newsLine.api.PostApi
import com.example.together.data.api.travels.TravelsRepository
import com.example.together.data.api.travels.api.TravelsApi
import com.example.together.data.api.user.api.ProfileApi
import com.example.together.data.api.user.repos.UserProfileRepository
import com.example.together.domain.auth.RegistrationCompiler
import com.example.together.features.splash.SplashActivity
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Component(modules = [AppModule::class, RetrofitModule::class, RepositoryModule::class, ApiModule::class, UtilModule::class])
@Singleton
interface AppComponent {
    fun inject(splashActivity: SplashActivity)

    fun provideContext(): Context

    fun provideRetrofit(): Retrofit

    fun provideProfileApi(): ProfileApi

    fun provideUserProfileRepository(): UserProfileRepository

    fun provideTravelsApi(): TravelsApi

    fun provideTravelsRepository(): TravelsRepository

    fun providePostApi(): PostApi

    fun providePostRepository(): PostRepository

    fun provideRegistrationCompiler(): RegistrationCompiler

    fun provideFriendsApi(): FriendsApi

    fun provideFriendsRepository(): FriendsRepository
}