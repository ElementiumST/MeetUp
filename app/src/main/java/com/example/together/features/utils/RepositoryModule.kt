package com.example.together.features.utils

import com.example.together.data.testRetrofit.travels.TravelsRepository
import com.example.together.data.testRetrofit.travels.TravelsRepositoryImpl
import com.example.together.data.testRetrofit.travels.api.TravelsApi
import com.example.together.data.testRetrofit.user.api.ProfileApi
import com.example.together.data.testRetrofit.user.repos.UserProfileRepository
import com.example.together.data.testRetrofit.user.repos.UserProfileRepositoryImpl
import com.example.together.features.home.ui.profile.di.ProfileScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideUserProfileRepository(profileApi: ProfileApi): UserProfileRepository {
        return UserProfileRepositoryImpl(profileApi)
    }

    @Singleton
    @Provides
    fun provideTravelsRepository(travelsApi: TravelsApi): TravelsRepository {
        return TravelsRepositoryImpl(travelsApi)
    }
}