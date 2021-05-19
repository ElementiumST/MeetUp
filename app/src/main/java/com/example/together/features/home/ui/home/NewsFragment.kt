package com.example.together.features.home.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.together.databinding.FragmentNewsBinding
import com.example.together.features.utils.App
import javax.inject.Inject

class NewsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: NewsViewModelFactory

    private val newsViewModel: NewsViewModel by viewModels { viewModelFactory }
    private lateinit var binding: FragmentNewsBinding
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        initDagger()
        subscribeOnPost()
        binding = FragmentNewsBinding.inflate(inflater)
        binding.newsList.layoutManager = LinearLayoutManager(requireContext())
        newsAdapter = NewsAdapter()
        binding.newsList.adapter = newsAdapter
        return binding.root
    }

    private fun subscribeOnPost() {
        newsViewModel.updatePosts()
        newsViewModel.posts.observe(viewLifecycleOwner) {
            newsAdapter.setPost(it)
        }
    }

    private fun initDagger() {
        DaggerNewsComponent.builder()
            .appComponent(App.appComponent)
            .build()
            .inject(this)
    }
}
