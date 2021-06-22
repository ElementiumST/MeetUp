package com.example.together.features.auth.signUp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.together.data.api.user.model.Account
import com.example.together.data.api.user.repos.SignInRepository
import com.example.together.data.api.user.repos.SignUpRepository
import com.example.together.domain.userdata.AccountHolder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class SignUpViewModel(
    private val signUpRepository: SignUpRepository,
    private val signInRepository: SignInRepository,
    private val accountHolder: AccountHolder,
    private val compositeDisposable: CompositeDisposable
) : ViewModel() {
    val signUpState = MutableLiveData(SignUpStatus.Await)
    fun signUp(
        email: String,
        password: String,
        firstName: String,
        secondName: String,
        hobby: String
    ) {
        signUpRepository.signUp(
            Account(
                email,
                email,
                password,
                firstName,
                secondName,
                hobby = hobby
            )
        )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                       doNext(email, password)
            }, {
                Timber.tag("SignUpRequest").e(it)
                doNext(email, password)
            })
            .also { compositeDisposable.add(it) }
    }

    private fun doNext(email: String, password: String) {
        signInRepository
            .signInWithLogin(email, password)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
            accountHolder.accessData = it
            signUpState.value = SignUpStatus.Success
        }, {
            Timber.tag("SignUpRequest").e(it)
            signUpState.value = SignUpStatus.Fail
        })
        .also { compositeDisposable.add(it) }
        }
}