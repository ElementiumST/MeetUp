package com.example.together.features.auth.signIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.together.data.api.user.repos.SignInRepository
import com.example.together.domain.userdata.AccountHolder
import io.reactivex.disposables.CompositeDisposable

class SignInViewModelFactory(
    private val signInRepository: SignInRepository,
    private val accountHolder: AccountHolder,
    private val compositeDisposable: CompositeDisposable
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SignInViewModel(
            signInRepository,
            accountHolder,
            compositeDisposable
        ) as T
    }

}