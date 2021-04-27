package com.example.together.features.home.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.together.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeFragmentViewModel: HomeFragmentViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        homeFragmentViewModel =
                ViewModelProvider(this).get(HomeFragmentViewModel::class.java)
        binding = FragmentHomeBinding.inflate(inflater)

        return binding.root
    }
}