package com.example.together.features.auth.username

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.together.domain.auth.RegistrationCompiler

class UsernameViewModelFactory(
        private val registrationCompiler: RegistrationCompiler
) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UsernameViewModel(
                registrationCompiler
        ) as T
    }
}