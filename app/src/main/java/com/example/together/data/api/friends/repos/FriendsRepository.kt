package com.example.together.data.api.friends.repos

import com.example.together.data.api.user.model.Profile
import io.reactivex.Single

interface FriendsRepository {
    fun getFriendsOfUser(): Single<List<Profile>>
}