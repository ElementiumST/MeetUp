package com.example.together.data.api.user.repos

import com.example.together.data.api.user.api.AuthApi
import com.example.together.data.api.user.model.AccessData
import com.example.together.data.api.user.model.SignInBody
import com.example.together.domain.userdata.AccountHolder
import com.google.android.gms.auth.api.signin.GoogleSignInApi
import io.reactivex.Single

class SignInRepositoryImpl(
    private val authApi: AuthApi,
) : SignInRepository {

    override fun signInWithLogin(login: String, password: String): Single<AccessData> {
        return authApi.signIn(SignInBody(
            "Password",
            login,
            password,
            "Default"
        ))
    }
}