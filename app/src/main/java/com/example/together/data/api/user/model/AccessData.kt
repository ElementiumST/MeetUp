package com.example.together.data.api.user.model

data class AccessData(
    val access_token: String,
    val tokenType: String,
    val expiresIn: Int,
    val refreshToken: String
)
