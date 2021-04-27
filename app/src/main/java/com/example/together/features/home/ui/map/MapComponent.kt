package com.example.together.features.home.ui.map

import com.example.together.data.testRetrofit.user.repos.UserProfileRepository
import com.example.together.features.home.ui.profile.ProfileFragment
import com.example.together.features.home.ui.profile.di.ProfileComponent
import com.example.together.features.home.ui.profile.di.ProfileModule
import com.example.together.features.home.ui.profile.di.ProfileScope
import com.example.together.features.utils.AppComponent
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class MapScope

@MapScope
@Component(dependencies = [AppComponent::class], modules = [MapModule::class])
interface MapComponent {
    fun inject(mapsFragment: MapsFragment)
}

@Module
class MapModule {
    @MapScope
    @Provides
    fun provideMapViewModelFactory(
    ): MapViewModelFactory {
        val compositeDisposable = CompositeDisposable()
        return MapViewModelFactory(
                compositeDisposable
        )
    }

}