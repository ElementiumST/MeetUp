package com.example.together.features.home.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.together.data.testRetrofit.user.model.Profile
import com.example.together.data.testRetrofit.user.repos.UserProfileRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class ProfileViewModel(
    private val compositeDisposable: CompositeDisposable
) : ViewModel() {
    companion object {
        const val TAG = "ProfileViewModel"
    }

}