package com.example.together.features.home.ui.profile

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class ProfileViewModel(
    private val compositeDisposable: CompositeDisposable
) : ViewModel() {
    companion object {
        const val TAG = "ProfileViewModel"
    }

}