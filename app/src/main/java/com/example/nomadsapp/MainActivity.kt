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

    /* η onCreate() είναι η πρώτη μέθοδος που καλείται σύμφωνα με το lifecycle του android στις
    activities και στην οποια αρχικοποιούμε το activity  */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().add(R.id.frame_layout, RecommendedTripFragment()).commit()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //εδω οριζουμε το layout με το οποιο ειναι συνδεδεμενη η κλάση στην περιπτωση μας το activity_main.xml
        setSupportActionBar(binding.toolBar) //θετουμε το toolbar περνώντας το με id που του εχουμε δωσει μεσα στο xml


        //δημιουργουμε εναν click listener για το μενου που βρισκεται αριστερα
        binding.toolBar.setNavigationOnClickListener{
            supportFragmentManager.beginTransaction().add(R.id.frame_layout_menu,MenuFragment() ).commit()
            /*με ην βοηθεια του supportFragmentManager αντικαθιστουμε
            το framelayout που εχουμε στο activity main με το fragment του μενου */
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        /* δημιουργουμε ενα click listener για το κουυμπι κατω δεξια και θετουμε στο intent
        την AddClientActivity και μεσω του startActivity ανοιγει η AddClientActivity  */
        binding.fabAddClient.setOnClickListener{
            val intent = Intent(this, AddClientActivity::class.java)
            startActivity(intent)
        }
    }
}