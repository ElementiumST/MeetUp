package com.example.together.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.together.data.testRetrofit.travels.TravelsRepository
import com.example.together.data.testRetrofit.user.repos.UserProfileRepository
import io.reactivex.disposables.CompositeDisposable

class HomeViewModelFactory(
        private val travelsRepository: TravelsRepository,
        private val userProfileRepository: UserProfileRepository,
        private val compositeDisposable: CompositeDisposable
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(
                travelsRepository,
                userProfileRepository,
                compositeDisposable
        ) as T
    }
}