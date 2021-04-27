package com.example.together.features.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.together.R
import com.example.together.data.testRetrofit.TestApi
import com.example.together.features.auth.AuthActivity
import com.example.together.features.utils.App
import com.vk.api.sdk.utils.VKUtils.getCertificateFingerprint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers.io
import javax.inject.Inject


class SplashActivity : AppCompatActivity() {


    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initializeDagger()
        supportActionBar?.hide()
        startActivity(Intent(this, AuthActivity::class.java))

    }
    private fun initializeDagger() = App.appComponent.inject(this)
}