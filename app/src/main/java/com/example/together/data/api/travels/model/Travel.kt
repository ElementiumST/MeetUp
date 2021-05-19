package com.example.together.data.api.travels.model

import com.example.together.data.api.newsLine.model.Position
import com.example.together.data.api.newsLine.model.Post

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