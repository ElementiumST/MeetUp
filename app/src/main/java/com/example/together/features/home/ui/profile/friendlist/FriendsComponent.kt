package com.example.together.features.home.ui.profile.friendlist

import com.example.together.data.api.friends.repos.FriendsRepository
import com.example.together.features.utils.AppComponent
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FriendsScope

@FriendsScope
@Component(dependencies = [AppComponent::class], modules = [FriendsModule::class])
interface FriendsComponent {
    fun inject(friendsListFragment: FriendsListFragment)
}

@Module
class FriendsModule {
    @FriendsScope
    @Provides
    fun provideFriendsListViewModelFactory(
        friendsRepository: FriendsRepository
    ): FriendsListViewModelFactory {
        val compositeDisposable = CompositeDisposable()
        return FriendsListViewModelFactory(
            friendsRepository,
            compositeDisposable
        )
    }
}