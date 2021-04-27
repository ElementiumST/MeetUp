package com.example.together.features.home

import com.example.together.data.testRetrofit.travels.TravelsRepository
import com.example.together.data.testRetrofit.user.repos.UserProfileRepository
import com.example.together.features.home.ui.map.MapViewModelFactory
import com.example.together.features.home.ui.map.MapsFragment
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