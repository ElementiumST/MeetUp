package com.example.together.features.tags

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.together.data.api.travels.model.Tag
import com.example.together.databinding.ItemTagBinding

class TagsAdapter(
    private var tags: List<Tag>
    ) : RecyclerView.Adapter<TagsAdapter.TagViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        val view = ItemTagBinding.inflate(LayoutInflater.from(parent.context))
        return TagViewHolder(view)
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.bind(tags[position])
    }

    override fun getItemCount(): Int {
        return tags.size
    }
    public fun setTags(tags: List<Tag>) {
        this.tags = tags
        notifyDataSetChanged()
    }

    inner class TagViewHolder(
        private val binding: ItemTagBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tag: Tag) {
            binding.text.text = tag.name
        }
    }
}