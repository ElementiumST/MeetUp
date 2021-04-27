package com.example.together.features.home.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.together.data.testRetrofit.user.repos.UserProfileRepository
import io.reactivex.disposables.CompositeDisposable


class ProfileViewModelFactory(
    private val compositeDisposable: CompositeDisposable
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel(
                compositeDisposable
        ) as T
    }
}