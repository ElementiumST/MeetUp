package com.example.together.data.api.newsLine.api

import com.example.together.data.api.newsLine.model.Post
import io.reactivex.Single
import retrofit2.http.GET

interface PostApi {
    @GET("/users/posts")
    fun getNewsPosts(): Single<List<Post>>
}