package com.example.together.data.testRetrofit.user.api

import com.example.together.data.testRetrofit.user.model.Profile
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfileApi {
    @GET("users/{userId}")
    fun getProfile(@Path("userId") userId: String): Single<Profile>
}