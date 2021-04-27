package com.example.together.data.testRetrofit.model

import com.example.together.data.testRetrofit.user.model.Profile

data class Post(
        val postId: String? = null,
        val title: String? = null,
        val body: String? = null,
        val date: Long? = null,
        val author: Profile? = null
)
