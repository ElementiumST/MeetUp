package com.example.together.data.testRetrofit.travels.model

import com.example.together.data.testRetrofit.model.Position
import com.example.together.data.testRetrofit.model.Post
import com.example.together.data.testRetrofit.user.model.Profile

data class Travel(
        var travelId: String? = null,
        var position: Position? = null,
        var name: String? = null,
        var members: List<String>? = null,
        var dateOfStart: String? = null,
        var tags: List<Tag>? = null,
        var images: List<String>? = null,
        var markerId: String? = null,
        var post: Post? = null
) {
}