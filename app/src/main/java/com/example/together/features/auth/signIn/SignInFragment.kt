package com.example.together.features.auth.signIn

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.together.R
import com.example.together.databinding.SignInFragmentBinding
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKScope


class SignInFragment : Fragment() {

    companion object {
        fun newInstance() = SignInFragment()
    }

    private lateinit var viewModel: SignInViewModel
    private lateinit var binding: SignInFragmentBinding
    private lateinit var googleSignInOptions: GoogleSignInOptions
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignInFragmentBinding.inflate(inflater)
        bindListeners()
        initGoogleSignInClient()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)
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
            findNavController().navigate(R.id.action_signInFragment_to_homeActivity)
        }
        binding.SignUp.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_usernameFragment)
        }
        binding.vkSignIn.setOnClickListener {
            startVKSingIn()
        }
        binding.googleSignIn.setOnClickListener {
            //TODO Google auth
        }
    }
    private fun startVKSingIn() {
        VK.login(requireActivity(), arrayListOf(VKScope.PHONE, VKScope.FRIENDS,VKScope.PHOTOS, VKScope.WALL))
    }

}