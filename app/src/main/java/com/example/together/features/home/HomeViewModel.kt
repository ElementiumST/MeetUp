package com.example.together.features.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.together.data.api.travels.TravelsRepository
import com.example.together.data.api.travels.model.Travel
import com.example.together.data.api.user.model.Profile
import com.example.together.data.api.user.repos.UserProfileRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit

class HomeViewModel(
        private val travelsRepository: TravelsRepository,
        private val userProfileRepository: UserProfileRepository,
        private val compositeDisposable: CompositeDisposable
): ViewModel() {
    companion object {
        const val TAG = "HomeViewModel"
    }
    val profile = MutableLiveData<Profile>()
    val travels = MutableLiveData<List<Travel>>()

    fun updateTravels() {
        travelsRepository.getMapTravels()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    travels.value = it
                }, {
                    Timber.tag(TAG).e(it)
                }).also { compositeDisposable.add(it) }
    }
    fun updateProfile() {
        userProfileRepository.updateUserProfile()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        {
                            profile.value = it
                        },
                        {
                            Timber.tag(TAG).e(it)
                        }
                )
                .also { compositeDisposable.add(it)}
    }

    fun init() {
        Observable.interval(0, 30, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    updateProfile()
                    updateTravels()
                }, {
                    Timber.tag(TAG).e(it)
                })
                .also { compositeDisposable.add(it) }

    }
}