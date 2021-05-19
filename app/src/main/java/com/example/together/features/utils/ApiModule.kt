package com.example.together.features.utils

import com.example.together.data.api.friends.api.FriendsApi
import com.example.together.data.api.newsLine.api.PostApi
import com.example.together.data.api.travels.api.TravelsApi
import com.example.together.data.api.user.api.ProfileApi
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

    @Singleton
    @Provides
    fun providePostApi(retrofit: Retrofit): PostApi {
        return retrofit.create(PostApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFriendsApi(retrofit: Retrofit): FriendsApi {
        return retrofit.create(FriendsApi::class.java)
    }
}