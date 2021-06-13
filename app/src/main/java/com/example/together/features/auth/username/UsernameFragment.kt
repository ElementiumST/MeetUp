package com.example.together.features.auth.username

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.together.R
import com.example.together.databinding.UsernameFragmentBinding
import com.example.together.features.auth.DaggerAuthComponent
import com.example.together.features.utils.App
import javax.inject.Inject

class UsernameFragment : Fragment() {

    companion object {
        fun newInstance() = UsernameFragment()
    }

    @Inject
    lateinit var usernameViewModelFactory: UsernameViewModelFactory

    private val viewModel: UsernameViewModel by viewModels { usernameViewModelFactory }
    private lateinit var binding: UsernameFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = UsernameFragmentBinding.inflate(inflater)
        initDagger()
        initFields()
        initCanNextObserver()
        initGoNextButton()
        return binding.root
    }

    private fun initGoNextButton() {
        binding.goNext.setOnClickListener {
            if(viewModel.canNext.value!!) {
                viewModel.onNextFragmentNavigate(
                        binding.firstName.getText(),
                        binding.secondName.getText()
                )
                findNavController().navigate(R.id.action_usernameFragment_to_phoneFragment)
            } else {
                Toast.makeText(context, resources.getString(R.string.invalidData), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun initFields() {
        binding.firstName.addTextChangeListener {
            viewModel.firstNameChange(it)
        }
        binding.secondName.addTextChangeListener {
            viewModel.secondNameChange(it)
        }
    }

    private fun initCanNextObserver() {
        viewModel.canNext.observe(viewLifecycleOwner) {
            if(it) {
                binding.validationName.visibility = View.VISIBLE
                binding.validationName.setFirstText("${binding.firstName.getText()} ${binding.secondName.getText()},")
            } else {
                binding.validationName.visibility = View.INVISIBLE
            }
        }
    }

    private fun initDagger() {
        DaggerAuthComponent.builder()
                .appComponent(App.appComponent)
                .build()
                .inject(this)
    }

}