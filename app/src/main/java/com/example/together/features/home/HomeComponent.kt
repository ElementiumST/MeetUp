package com.example.together.features.home

import com.example.together.data.api.travels.TravelsRepository
import com.example.together.data.api.user.repos.UserProfileRepository
import com.example.together.features.utils.AppComponent
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Scope


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class HomeScope

@HomeScope
@Component(dependencies = [AppComponent::class], modules = [HomeModule::class])
interface HomeComponent {
    fun inject(homeActivity: HomeActivity)
}

@Module
class HomeModule {
    @HomeScope
    @Provides
    fun provideHomeViewModelFactory(
            userProfileRepository: UserProfileRepository,
            travelsRepository: TravelsRepository
    ): HomeViewModelFactory {
        val compositeDisposable = CompositeDisposable()
        return HomeViewModelFactory(
                travelsRepository,
                userProfileRepository,
                compositeDisposable
        )
    }


}