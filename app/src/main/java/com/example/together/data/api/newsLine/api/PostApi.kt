package com.example.together.data.api.newsLine.api

import com.example.together.data.api.newsLine.model.Post
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface PostApi {
    @GET("Post")
    fun getNewsPosts(@Header("Authorization") token: String): Single<List<Post>>
    @POST("Post")
    fun createPost(@Header("Authorization") token: String, @Body body: String): Single<Completable>
}