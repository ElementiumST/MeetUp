package com.example.together.features.home.ui.map

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