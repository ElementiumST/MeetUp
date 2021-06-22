package com.example.together.data.api.user.api

import com.example.together.data.api.user.model.AccessData
import com.example.together.data.api.user.model.Account
import com.example.together.data.api.user.model.SignInBody
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("oauth2/token")
    fun signIn(@Body body: SignInBody): Single<AccessData>

    @POST("registrations")
    fun signUp(@Body account: Account): Single<Completable>
}