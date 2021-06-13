package com.example.together.features.home.newtravel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.disposables.CompositeDisposable

class NewTravelViewModelFactory(
    private val compositeDisposable: CompositeDisposable
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewTravelViewModel(
            compositeDisposable
        ) as T
    }
}