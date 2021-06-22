package com.example.together.features.auth.signIn

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.together.data.api.user.repos.SignInRepository
import com.example.together.domain.userdata.AccountHolder
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow

class SignInViewModel(
    private val signInRepository: SignInRepository,
    private val accountHolder: AccountHolder,
    private val compositeDisposable: CompositeDisposable
) : ViewModel() {
    val loginState = MutableLiveData(SignInStatus.Await)

    fun onVKSignInSuccess() {

    }

    fun setGoogleAccount(account: GoogleSignInAccount?) {

    }

    fun startSignInRequest(login: String, password: String) {
        signInRepository.signInWithLogin(
            login,
            password
        )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                loginState.value = SignInStatus.Confirmed
                accountHolder.accessData = it
            }, {
                loginState.value = SignInStatus.Rejected
            })
            .also { compositeDisposable.add(it) }
    }
}