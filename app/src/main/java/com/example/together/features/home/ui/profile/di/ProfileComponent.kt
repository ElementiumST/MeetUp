package com.example.together.features.home.ui.profile.di

import com.example.together.data.testRetrofit.user.api.ProfileApi
import com.example.together.data.testRetrofit.user.repos.UserProfileRepository
import com.example.together.data.testRetrofit.user.repos.UserProfileRepositoryImpl
import com.example.together.features.home.ui.profile.ProfileFragment
import com.example.together.features.home.ui.profile.ProfileViewModelFactory
import com.example.together.features.utils.AppComponent
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ProfileScope

@ProfileScope
@Component(dependencies = [AppComponent::class], modules = [ProfileModule::class])
interface ProfileComponent {
    fun inject(profileFragment: ProfileFragment)
}
@Module
class ProfileModule {
    @ProfileScope
    @Provides
    fun provideProfileViewModelFactory(
    ): ProfileViewModelFactory {
        val compositeDisposable = CompositeDisposable()
        return ProfileViewModelFactory(
                compositeDisposable
        )
    }
}