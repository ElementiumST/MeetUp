package com.example.together.features.home.ui.home

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.together.data.api.newsLine.model.Post
import com.example.together.features.views.post.PostView

class NewsAdapter(
    private var posts: List<Post> = listOf()
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = PostView(
            post = null,
            context = parent.context,
            null
        ).apply {
            layoutParams = RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
            )
        }
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun setPost(posts: List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    class NewsViewHolder(
        private val postView: PostView
    ) : RecyclerView.ViewHolder(postView) {
        fun bind(post: Post) {
            postView.setPost(post)
        }
    }
}