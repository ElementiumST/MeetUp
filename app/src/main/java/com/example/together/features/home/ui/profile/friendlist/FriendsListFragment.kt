package com.example.together.features.home.ui.profile.friendlist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.together.R
import com.example.together.databinding.FriendsListFragmentBinding
import com.example.together.features.utils.App
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class FriendsListFragment : Fragment() {

    companion object {
        fun newInstance() = FriendsListFragment()
    }
    @Inject
    lateinit var viewModelFactory: FriendsListViewModelFactory

    private val viewModel: FriendsListViewModel by viewModels { viewModelFactory }
    private lateinit var binding: FriendsListFragmentBinding
    private lateinit var adapter: FriendsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FriendsListFragmentBinding.inflate(inflater)
        initDagger()
        initFriendList()
        return binding.root
    }

    private fun initFriendList() {
        binding.list.layoutManager = LinearLayoutManager(context)
        adapter = FriendsAdapter()
        binding.list.adapter = adapter
        viewModel.updateFriendList()
        viewModel.friendList.observe(viewLifecycleOwner) {
            adapter.setProfiles(it)
        }
    }

    private fun initDagger() {
        DaggerFriendsComponent
            .builder()
            .appComponent(App.appComponent)
            .build()
            .inject(this)
    }


}