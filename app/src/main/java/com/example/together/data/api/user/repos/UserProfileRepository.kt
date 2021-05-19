package com.example.together.data.api.user.repos

import com.example.together.data.api.user.model.Profile
import io.reactivex.Single

interface UserProfileRepository {
    fun updateUserProfile(): Single<Profile>

}