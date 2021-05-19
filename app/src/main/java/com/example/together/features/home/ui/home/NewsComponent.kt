package com.example.together.features.home.ui.home

import com.example.together.data.api.newsLine.PostRepository
import com.example.together.features.utils.AppComponent
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class NewsScope

@NewsScope
@Component(dependencies = [AppComponent::class], modules = [NewsModule::class])
interface NewsComponent {
    fun inject(newsFragment: NewsFragment)
}

@Module
class NewsModule {
    @NewsScope
    @Provides
    fun provideMapViewModelFactory(
        postRepository: PostRepository
    ): NewsViewModelFactory {
        val compositeDisposable = CompositeDisposable()
        return NewsViewModelFactory(
            postRepository,
            compositeDisposable
        )
    }

}