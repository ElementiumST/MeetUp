package com.example.together.data.api.user.model

data class Account(
        val email: String? = null,
        val login: String? = null,
        val password: String? = null,
        val firstName: String? = null,
        val secondName: String? = null,
        val numberPhone: String = "89198673914",
        val authTypeBinding: String = "Default",
        val hobby: String? = null
) {

}
