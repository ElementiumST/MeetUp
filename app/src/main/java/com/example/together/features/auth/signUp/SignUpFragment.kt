package com.example.together.features.auth.signUp

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
import com.example.together.databinding.SignUpFragmentBinding
import com.example.together.features.auth.signIn.DaggerSignInComponent
import com.example.together.features.utils.App
import javax.inject.Inject

class SignUpFragment : Fragment() {

    companion object {
        fun newInstance() = SignUpFragment()
    }
    @Inject
    lateinit var viewModelFactory: SignUpViewModelFactory

    private val viewModel: SignUpViewModel by viewModels { viewModelFactory }
    private lateinit var binding: SignUpFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignUpFragmentBinding.inflate(inflater)
        initDagger()
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        binding.signUp
            .setOnClickListener {
                viewModel.signUp(
                    binding.email.getText(),
                    binding.password.getText(),
                    binding.fName.getText(),
                    binding.sName.getText(),
                    binding.about.getText()
                )
            }
        viewModel.signUpState.observe(viewLifecycleOwner) {
            when(it) {
                SignUpStatus.Success -> findNavController().navigate(R.id.action_signUpFragment_to_homeActivity)
                SignUpStatus.Fail -> Toast.makeText(context, "Поля заполнены некорректно", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun initDagger() {
        DaggerSignUpComponent
            .builder()
            .appComponent(App.appComponent)
            .build()
            .inject(this)
    }

}