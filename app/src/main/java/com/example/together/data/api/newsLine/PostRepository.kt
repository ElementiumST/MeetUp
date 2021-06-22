package com.example.together.data.api.newsLine

import com.example.together.data.api.newsLine.model.Post
import io.reactivex.Completable
import io.reactivex.Single

interface PostRepository {
    fun getNewsLine(): Single<MutableList<Post>>
    fun getUserNews(): Single<List<Post>>
    fun createPost(text: String): Single<Completable>
}