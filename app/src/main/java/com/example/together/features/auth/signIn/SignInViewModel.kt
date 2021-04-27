package com.example.together.features.auth.signIn

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

class SignInViewModel : ViewModel() {
    fun onVKSignInSuccess() {
    }

    fun setGoogleAccount(account: GoogleSignInAccount?) {
        Log.e("google account", account.toString())
    }
    // TODO: Implement the ViewModel
}