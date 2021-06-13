package com.example.together.features.home.ui.profile.friendlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.together.data.api.friends.repos.FriendsRepository
import io.reactivex.disposables.CompositeDisposable

class FriendsListViewModelFactory(
    private val friendsRepository: FriendsRepository,
    private val compositeDisposable: CompositeDisposable
) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FriendsListViewModel(
            friendsRepository,
            compositeDisposable
        ) as T
    }

}