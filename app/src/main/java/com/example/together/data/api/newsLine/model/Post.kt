package com.example.together.data.api.newsLine.model

import com.example.together.data.api.user.model.Profile

data class Post(
        val postId: String? = null,
        val body: String? = null,
        val date: String? = null,
        val likes: Int? = null,
        val reposts: Int? = null,
        val author: Profile? = null
)
