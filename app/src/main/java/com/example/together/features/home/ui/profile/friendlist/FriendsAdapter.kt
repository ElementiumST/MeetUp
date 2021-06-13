package com.example.together.features.home.ui.profile.friendlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.together.R
import com.example.together.data.api.user.model.Profile
import com.example.together.databinding.ItemProfileBinding
import com.example.together.features.utils.getUsername

class FriendsAdapter: RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder>() {

    private var profiles: List<Profile> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsViewHolder {
        return FriendsViewHolder(ItemProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: FriendsViewHolder, position: Int) {
        holder.bind(profiles[position])
    }

    override fun getItemCount(): Int {
        return profiles.size
    }

    fun setProfiles(profiles: List<Profile>) {
        this.profiles = profiles
        notifyDataSetChanged()
    }

    inner class FriendsViewHolder(
            private val binding: ItemProfileBinding
        ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(profile: Profile) {
            profile.avatarLink?.let { binding.image.setImage(profile.avatarLink) }
            binding.username.text = profile.getUsername()
            binding.status.text = profile.status
        }
    }
}