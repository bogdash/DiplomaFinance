package com.bogdash.diplomafinance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bogdash.diplomafinance.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navController = this.findNavController(R.id.nav_host_fragment)
        val bottomNavigationMenu: BottomNavigationView = binding.bottomNavigationMenu
        bottomNavigationMenu.setupWithNavController(navController)
    }
}