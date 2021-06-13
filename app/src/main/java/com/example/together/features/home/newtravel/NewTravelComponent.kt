package com.example.together.features.home.newtravel

import com.example.together.features.utils.AppComponent
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class NewTravelScope

@NewTravelScope
@Component(dependencies = [AppComponent::class], modules = [NewTravelModule::class])
interface NewTravelComponent {
    fun inject(newTravelBottomFragment: NewTravelBottomFragment)
}

@Module
class NewTravelModule {
    @NewTravelScope
    @Provides
    fun provideNewTravelViewModelFactory(

    ): NewTravelViewModelFactory {
        val compositeDisposable = CompositeDisposable()
        return NewTravelViewModelFactory(
            compositeDisposable
        )
    }

}