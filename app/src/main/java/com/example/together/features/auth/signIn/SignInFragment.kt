package com.example.together.features.auth.signIn

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.together.R
import com.example.together.databinding.SignInFragmentBinding
import com.example.together.features.utils.App
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKScope
import javax.inject.Inject


class SignInFragment : Fragment() {

    companion object {
        fun newInstance() = SignInFragment()
    }
    @Inject
    lateinit var signInViewModelFactory: SignInViewModelFactory
    private val viewModel: SignInViewModel by viewModels {signInViewModelFactory}
    private lateinit var binding: SignInFragmentBinding
    private lateinit var googleSignInOptions: GoogleSignInOptions
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignInFragmentBinding.inflate(inflater)
        initDagger()
        bindListeners()
        bindObservers()
        initGoogleSignInClient()
        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val callback = object: VKAuthCallback {
            override fun onLogin(token: VKAccessToken) {
                viewModel.onVKSignInSuccess()
            }

            override fun onLoginFailed(errorCode: Int) {

            }
        }
        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun initGoogleSignInClient() {
        googleSignInOptions =
                GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestEmail()
                        .build()

    }

    private fun bindListeners() {
        binding.SignIn.setOnClickListener {
            if(binding.login.getText().isEmpty() || binding.password.getText().isEmpty()) {
                Toast.makeText(context, "Поля должны быть заполнены!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            viewModel.startSignInRequest(
                binding.login.getText(),
                binding.password.getText()
            )
//            Toast.makeText(context, "Неправильное имя пользователя или пароль", Toast.LENGTH_LONG).show()
//            findNavController().navigate(R.id.action_signInFragment_to_homeActivity)
        }
        binding.SignUp.setOnClickListener {
//            findNavController().navigate(R.id.action_signInFragment_to_usernameFragment)
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }
        binding.vkSignIn.setOnClickListener {
            startVKSingIn()
        }
        binding.googleSignIn.setOnClickListener {
            //TODO Google auth
        }
    }

    private fun bindObservers() {
        viewModel.loginState.observe(viewLifecycleOwner) {
            when (it) {
                SignInStatus.Confirmed -> findNavController().navigate(R.id.action_signInFragment_to_homeActivity)
                SignInStatus.Rejected -> Toast.makeText(context, "Неправильное имя пользователя или пароль", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun startVKSingIn() {
        VK.login(requireActivity(), arrayListOf(VKScope.PHONE, VKScope.FRIENDS,VKScope.PHOTOS, VKScope.WALL))
    }
    private fun initDagger() {
        DaggerSignInComponent.builder()
            .appComponent(App.appComponent)
            .build()
            .inject(this)
    }
}
