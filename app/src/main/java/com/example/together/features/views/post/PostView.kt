package com.example.together.features.views.post

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import com.example.together.data.api.newsLine.model.Post
import com.example.together.databinding.ItemPostBinding

@SuppressLint("SetTextI18n", "ViewConstructor")
class PostView(post: Post?, context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs, 0) {
    val binding = ItemPostBinding.inflate(LayoutInflater.from(context))
    init {
        addView(binding.root)
        post?.let { setPost(it) }

    }
    fun setPost(post: Post) {
        binding.date.text = post.date
        binding.username.text = "${post.author?.firstName} ${post.author?.secondName}"
        binding.text.text = post.body
        binding.likeButton.text = parseLikeOrRepost(post.likes!!)
        binding.repostBtn.text = parseLikeOrRepost(post.reposts!!)
        Glide.with(this)
            .load(post.author?.avatarLink)
            .into(binding.profileImage)
    }

    private fun parseLikeOrRepost(likes: Int): String {
        return when {
            likes in 1000..999999 -> "${likes/1000}k"
            likes > 1000000 -> "${likes/1000000}m"
            else -> "$likes"
        }

    }
}