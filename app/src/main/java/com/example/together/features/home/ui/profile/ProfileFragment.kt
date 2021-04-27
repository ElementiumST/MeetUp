package com.example.together.features.home.ui.profile

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.together.R
import com.example.together.databinding.FragmentProfileBinding
import com.example.together.features.home.HomeActivity
import com.example.together.features.home.HomeViewModel
import com.example.together.features.home.ui.profile.di.DaggerProfileComponent
import com.example.together.features.utils.App
import timber.log.Timber
import javax.inject.Inject

class ProfileFragment : Fragment() {

    companion object {
        const val TAG = "ProfileFragment"
    }
    @Inject
    lateinit var profileViewModelFactory: ProfileViewModelFactory

    private val viewModel: ProfileViewModel by viewModels { profileViewModelFactory }


    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater)
        initDagger()
        setupProfileData()
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun setupProfileData() {
        (requireActivity() as HomeActivity).viewModel
                .apply {
                    updateProfile()
                    profile.observe(viewLifecycleOwner) {
                        it.avatarLink?.let { it1 -> binding.avatar.setImage(it1) }
                        binding.username.text = "${it.firstName} ${it.secondName}"
                        binding.friends.text = it.friends.toString()
                        binding.member.text = it.meetMemberCount.toString()
                        binding.owner.text = it.meetOwnedCount.toString()
                        binding.status.text = if (it.status.isNullOrEmpty()) {
                            getString(R.string.setStatus)
                        } else {
                            it.status
                        }
                    }
                }
    }


    private fun initDagger() {
        DaggerProfileComponent
                .builder()
                .appComponent(App.appComponent)
                .build()
                .inject(this)
    }
}