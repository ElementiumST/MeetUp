package com.example.together.domain.auth

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

interface RegistrationCompiler {
    fun setUsername(firstName: String, secondName: String)
    fun setPhone(phone: String)
    fun setPassword(password: String)
}