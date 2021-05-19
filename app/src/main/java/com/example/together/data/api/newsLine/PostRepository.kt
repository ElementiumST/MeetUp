package com.example.together.data.api.newsLine

import com.example.together.data.api.newsLine.model.Post
import io.reactivex.Single

interface PostRepository {
    fun getNewsLine(): Single<List<Post>>
    fun getUserNews(): Single<List<Post>>
}