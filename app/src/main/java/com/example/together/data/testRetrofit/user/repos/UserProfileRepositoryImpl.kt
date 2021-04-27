package com.example.together.data.testRetrofit.user.repos

import com.example.together.data.testRetrofit.model.Position
import com.example.together.data.testRetrofit.user.api.ProfileApi
import com.example.together.data.testRetrofit.user.model.Profile
import io.reactivex.Single
import timber.log.Timber

class UserProfileRepositoryImpl(
    private val profileApi: ProfileApi,
    ): UserProfileRepository {
    companion object {
        const val DATA_KEY = "profileKey"
        const val TAG = "UserProfileRepositoryImpl"
    }
    override fun updateUserProfile(): Single<Profile> {
        //TODO api
        val profile = Profile(
            "8274278348273",
            "Ник",
            "Рутович",
            "https://sun9-66.userapi.com/impf/c637227/v637227071/511b9/9bHHnpkD8r8.jpg?size=512x512&quality=96&proxy=1&sign=649b43e820821859da6ef196073f0c77&type=album",
            "Админ",
            -1,
            12,
            12,
                Position(
                        "gdukfgjlfds",
                        51.771718,
                        55.140528
                )
        )

        return Single.just(profile)
    }
}