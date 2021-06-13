package com.example.together.features.home.ui.profile.friendlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.together.data.api.friends.repos.FriendsRepository
import com.example.together.data.api.user.model.Profile
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class FriendsListViewModel(
    private val friendsRepository: FriendsRepository,
    private val compositeDisposable: CompositeDisposable
) : ViewModel() {
    companion object {
        const val TAG = "FriendsListViewModel"
    }
    val friendList = MutableLiveData<List<Profile>>()
    fun updateFriendList() {
        friendsRepository
            .getFriendsOfUser()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe ({ it ->
                friendList.value = it
            }, {
                Timber.tag(TAG).e(it)
            })
            .also { compositeDisposable.add(it) }
    }
}