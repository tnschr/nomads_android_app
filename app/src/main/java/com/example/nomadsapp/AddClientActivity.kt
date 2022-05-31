package com.example.nomadsapp

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nomadsapp.databinding.ActivityAddClientBinding
import com.example.nomadsapp.domain.Client
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class AddClientActivity: AppCompatActivity() {

    lateinit var binding: ActivityAddClientBinding
    private val clientCollectionRef = Firebase.firestore.collection("clients")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddClientBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonInsertClient.setOnClickListener {
            val firstName = binding.editTextFirstName.text.toString()
            val lastName = binding.editTextLastName.text.toString()
            val hotelName = binding.editTextHotelName.text.toString()
            val tripNumber = binding.editTextTripNumber.text.toString().toInt()
            val client = Client(firstName, lastName,tripNumber, hotelName)
            saveClients(client)
        }
    }

    private fun saveClients(client: Client) = CoroutineScope(Dispatchers.IO).launch {
        try{
            clientCollectionRef.add(client).await()
            withContext(Dispatchers.Main){
                Toast.makeText(this@AddClientActivity, "Ο πελάτης καταχωρήθηκε επιτυχώς", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception){
            withContext(Dispatchers.Main){
                Toast.makeText(this@AddClientActivity, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}