package com.example.together.features.auth.username

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.together.domain.auth.RegistrationCompiler

class UsernameViewModel(
        private val registrationCompiler: RegistrationCompiler
) : ViewModel() {
    val canNext = MutableLiveData(false)

    private var isFirstNameFulfilled: Boolean = false
    private var isSecondNameFulfilled: Boolean = false

    fun secondNameChange(it: String) {
        isSecondNameFulfilled = it.length > 2
        updateStatus()
    }

    fun firstNameChange(it: String) {
        isFirstNameFulfilled = it.length > 2
        updateStatus()
    }

    private fun updateStatus() {
        canNext.value = isFirstNameFulfilled && isSecondNameFulfilled
    }
    fun onNextFragmentNavigate(
            firstName: String,
            secondName: String
    ) {
        registrationCompiler
                .setUsername(firstName, secondName)
    }

}