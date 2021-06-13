package com.example.together.features.home

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.together.R
import com.example.together.databinding.ActivityHomeBinding
import com.example.together.features.home.newtravel.NewTravelBottomFragment
import com.example.together.features.utils.App
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory

    val viewModel: HomeViewModel by viewModels { homeViewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDagger()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        viewModel.init()
        supportActionBar?.hide()
        val navView: BottomNavigationView = binding.bottomNavigationView
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_map, R.id.navigation_invite, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false

        binding.addTravelFab.setOnClickListener {
            NewTravelBottomFragment
                .newInstance()
                .show(supportFragmentManager, NewTravelBottomFragment.TAG)
        }
    }

    private fun initDagger() {
        DaggerHomeComponent
                .builder()
                .appComponent(App.appComponent)
                .build()
                .inject(this)
    }

}