package com.example.together.data.api.user.repos

import com.example.together.data.api.user.api.AuthApi
import com.example.together.data.api.user.model.Account
import io.reactivex.Completable
import io.reactivex.Single

class SignUpRepositoryImpl(
    private val authApi: AuthApi
): SignUpRepository {
    override fun signUp(account: Account): Single<Completable> {
        return authApi.signUp(account)
    }
}