package com.example.nomadsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewbinding.ViewBinding
import com.example.nomadsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setSupportActionBar(binding.toolBar)

        binding.toolBar.setNavigationOnClickListener{
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
       /* navController = findNavController(R.id.frame_layout_menu)
       binding.navigationView.setupWithNavController(navController)*/


    }
}