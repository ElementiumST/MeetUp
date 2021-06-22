package com.example.together.features.auth.signUp

import com.example.together.data.api.user.repos.SignInRepository
import com.example.together.data.api.user.repos.SignUpRepository
import com.example.together.domain.userdata.AccountHolder
import com.example.together.features.auth.signIn.SignInFragment
import com.example.together.features.auth.signIn.SignInModule
import com.example.together.features.auth.signIn.SignInScope
import com.example.together.features.auth.signIn.SignInViewModelFactory
import com.example.together.features.utils.AppComponent
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SignUpScope

@SignUpScope
@Component(dependencies = [AppComponent::class], modules = [SignUpModule::class])
interface SignUpComponent {
    fun inject(signUpFragment: SignUpFragment)
}
@Module
class SignUpModule {
    @SignUpScope
    @Provides
    fun provideSignUpViewModelFactory(
        signUpRepository: SignUpRepository,
        signInRepository: SignInRepository,
        accountHolder: AccountHolder
    ): SignUpViewModelFactory {
        val compositeDisposable = CompositeDisposable()
        return SignUpViewModelFactory(
            signUpRepository,
            signInRepository,
            accountHolder,
            compositeDisposable
        )
    }
}