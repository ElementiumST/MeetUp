package com.example.together.data.api.user.repos

import com.example.together.data.api.user.model.Account
import io.reactivex.Completable
import io.reactivex.Single

interface SignUpRepository {
    fun signUp(account: Account): Single<Completable>
}