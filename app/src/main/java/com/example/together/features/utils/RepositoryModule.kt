package com.example.together.features.utils

import com.example.together.data.api.friends.api.FriendsApi
import com.example.together.data.api.friends.repos.FriendsRepository
import com.example.together.data.api.friends.repos.FriendsRepositoryImpl
import com.example.together.data.api.newsLine.PostRepository
import com.example.together.data.api.newsLine.PostRepositoryImpl
import com.example.together.data.api.newsLine.api.PostApi
import com.example.together.data.api.travels.TravelsRepository
import com.example.together.data.api.travels.TravelsRepositoryImpl
import com.example.together.data.api.travels.api.TravelsApi
import com.example.together.data.api.user.api.AuthApi
import com.example.together.data.api.user.api.ProfileApi
import com.example.together.data.api.user.repos.*
import com.example.together.domain.userdata.AccountHolder
import dagger.Module
import dagger.Provides
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

    @Singleton
    @Provides
    fun providePostRepository(accountHolder: AccountHolder, postApi: PostApi): PostRepository {
        return PostRepositoryImpl(postApi, accountHolder)
    }

    @Provides
    @Singleton
    fun provideFriendsRepository(friendsApi: FriendsApi): FriendsRepository {
        return FriendsRepositoryImpl(friendsApi)
    }

    @Provides
    @Singleton
    fun provideSignInRepository(authApi: AuthApi): SignInRepository {
        return SignInRepositoryImpl(authApi)
    }

    @Provides
    @Singleton
    fun provideSignUpRepository(authApi: AuthApi): SignUpRepository {
        return SignUpRepositoryImpl(authApi)
    }
}