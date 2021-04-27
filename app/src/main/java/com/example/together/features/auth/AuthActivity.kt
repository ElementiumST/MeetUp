package com.example.together.features.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.together.R
import com.example.together.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    lateinit var bindings: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = DataBindingUtil.setContentView(this, R.layout.activity_auth);
        supportActionBar?.hide()
    }
}