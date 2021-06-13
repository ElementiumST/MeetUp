package com.example.together.features.home.newtravel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.together.databinding.NewTravelBottomFragmentBinding
import com.example.together.features.utils.App
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import javax.inject.Inject

class NewTravelBottomFragment: BottomSheetDialogFragment() {
    companion object {
        const val TAG = "NewTravelBottomFragment"
        fun newInstance(): NewTravelBottomFragment {
            return NewTravelBottomFragment()
        }
    }
    @Inject
    lateinit var viewModelFactory: NewTravelViewModelFactory

    private val viewModel: NewTravelViewModel by viewModels { viewModelFactory }
    private lateinit var binding: NewTravelBottomFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NewTravelBottomFragmentBinding.inflate(inflater, container, false)
        initDagger()
        return binding.root
    }

    private fun initDagger() {
        DaggerNewTravelComponent
            .builder()
            .appComponent(App.appComponent)
            .build()
            .inject(this)
    }

}