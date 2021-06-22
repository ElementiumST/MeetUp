package com.example.together.features.utils

import android.content.Context
import com.example.together.domain.auth.RegistrationCompiler
import com.example.together.domain.auth.RegistrationCompilerImpl
import com.example.together.domain.userdata.AccountHolder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilModule {
    @Singleton
    @Provides
    fun provideRegistrationCompiler(context: Context): RegistrationCompiler {
        return RegistrationCompilerImpl(context)
    }
    @Singleton
    @Provides
    fun provideAccountHolder(): AccountHolder {
        return AccountHolder()
    }
}