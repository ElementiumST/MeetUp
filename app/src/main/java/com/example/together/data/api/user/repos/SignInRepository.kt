package com.example.together.data.api.user.repos

import com.example.together.data.api.user.model.AccessData
import io.reactivex.Single

interface SignInRepository {
    fun signInWithLogin(login: String, password: String): Single<AccessData>
}