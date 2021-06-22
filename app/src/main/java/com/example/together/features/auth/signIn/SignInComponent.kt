package com.example.together.features.auth.signIn

import com.example.together.data.api.user.repos.SignInRepository
import com.example.together.domain.userdata.AccountHolder
import com.example.together.features.utils.AppComponent
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SignInScope

@SignInScope
@Component(dependencies = [AppComponent::class], modules = [SignInModule::class])
interface SignInComponent {
    fun inject(signInFragment: SignInFragment)
}

@Module
class SignInModule {
    @SignInScope
    @Provides
    fun provideSignInViewModelFactory(
        signInRepository: SignInRepository,
        accountHolder: AccountHolder
    ): SignInViewModelFactory {
        val compositeDisposable = CompositeDisposable()
        return SignInViewModelFactory(
            signInRepository,
            accountHolder,
            compositeDisposable
        )
    }
}