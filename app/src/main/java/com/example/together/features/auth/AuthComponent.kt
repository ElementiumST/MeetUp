package com.example.together.features.auth

import com.example.together.domain.auth.RegistrationCompiler
import com.example.together.features.auth.username.UsernameFragment
import com.example.together.features.auth.username.UsernameViewModel
import com.example.together.features.auth.username.UsernameViewModelFactory
import com.example.together.features.utils.AppComponent
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AuthScope

@AuthScope
@Component(dependencies = [AppComponent::class], modules = [AuthModule::class])
interface AuthComponent {
    fun inject(usernameFragment: UsernameFragment)
}

@Module
class AuthModule {
    @AuthScope
    @Provides
    fun provideUsernameViewModelFactory(
            registrationCompiler: RegistrationCompiler
    ): UsernameViewModelFactory {
        return UsernameViewModelFactory(
            registrationCompiler
        )
    }
}