package com.example.together.data.api.di

import com.example.together.data.api.TestApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class TestApiModule {
    @Provides
    @Singleton
    fun provideTestApi(retrofit: Retrofit) =
        retrofit.create(TestApi::class.java)
}