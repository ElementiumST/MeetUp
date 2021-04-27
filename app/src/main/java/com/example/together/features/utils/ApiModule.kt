package com.example.together.features.utils

import com.example.together.data.testRetrofit.travels.api.TravelsApi
import com.example.together.data.testRetrofit.user.api.ProfileApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {
    @Singleton
    @Provides
    fun provideProfileApi(retrofit: Retrofit): ProfileApi {
        return retrofit.create(ProfileApi::class.java)
    }
    @Singleton
    @Provides
    fun provideTravelsApi(retrofit: Retrofit): TravelsApi {
        return retrofit.create(TravelsApi::class.java)
    }

}