package com.example.together.data.api

import com.example.together.data.api.newsLine.model.Post
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET


interface TestApi {
    @GET("posts")
    fun getPosts(): Single<Response<Array<Post>>>
}