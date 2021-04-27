package com.example.together.data.testRetrofit.user.repos

import com.example.together.data.testRetrofit.user.model.Profile
import io.reactivex.Single

interface UserProfileRepository {
    fun updateUserProfile(): Single<Profile>

}