package com.example.together.features.home.ui.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.disposables.CompositeDisposable

class MapViewModelFactory(
        private val compositeDisposable: CompositeDisposable
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MapViewModel(
                compositeDisposable,
        ) as T
    }
}