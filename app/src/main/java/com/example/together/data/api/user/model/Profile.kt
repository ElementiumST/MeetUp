package com.example.together.data.api.user.model

import com.example.together.data.api.newsLine.model.Position

data class Profile(
        val userId: String? = null,
        val firstName: String? = null,
        val secondName: String? = null,
        val avatarLink: String? = null,
        val status: String? = null,
        val friends: Int? = null,
        val meetMemberCount: Int? = null,
        val meetOwnedCount: Int? = null,
        val homePosition: Position? = null
)
