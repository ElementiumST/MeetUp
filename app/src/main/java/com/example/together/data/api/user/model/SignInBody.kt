package com.example.together.data.api.user.model

data class SignInBody(
    val grantType: String = "RefreshToken",
    val username: String,
    val password: String,
    val authType: String = "Default",
    val refreshToken: String? = null
) {
}