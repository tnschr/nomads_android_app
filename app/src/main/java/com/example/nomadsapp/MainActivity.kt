package com.example.nomadsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewbinding.ViewBinding
import com.example.nomadsapp.databinding.ActivityMainBinding
import com.example.nomadsapp.domain.Client
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.squareup.okhttp.Dispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().add(R.id.frame_layout, RecommendedTripFragment()).commit()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBar)

        binding.toolBar.setNavigationOnClickListener{
            supportFragmentManager.beginTransaction().add(R.id.frame_layout_menu,MenuFragment() ).commit()
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        binding.fabAddClient.setOnClickListener{
            val intent = Intent(this, AddClientActivity::class.java)
            startActivity(intent)
        }
    }
}