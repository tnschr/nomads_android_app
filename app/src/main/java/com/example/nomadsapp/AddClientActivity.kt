package com.example.nomadsapp

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nomadsapp.databinding.ActivityAddClientBinding
import com.example.nomadsapp.domain.Client
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.StringBuilder

class AddClientActivity: AppCompatActivity() {

    lateinit var binding: ActivityAddClientBinding
    //δημιουργια collection Client στην Firestore
    private val clientCollectionRef = Firebase.firestore.collection("clients")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddClientBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* μεσω του click listener περναμε τις τιμες των edit texts, σε ενα αντικειμενο τυπου clients και καλουμε την saveClients */
        binding.buttonInsertClient.setOnClickListener {
            val firstName = binding.editTextFirstName.text.toString()
            val lastName = binding.editTextLastName.text.toString()
            val hotelName = binding.editTextHotelName.text.toString()
            val tripNumber = binding.editTextTripNumber.text.toString().toInt()
            val client = Client(firstName, lastName,tripNumber, hotelName)
            saveClients(client)
        }

        subscribeToRealtimeUpdates()

        binding.buttonDeleteClient.setOnClickListener {
            val client = getClient()
            deleteClient(client)
        }

        binding.buttonUpdateClient.setOnClickListener {
            val oldClient = getClient()
            val newClientMap = getNewClientMap()
            updateClient(oldClient, newClientMap)
        }
    }

    private fun getClient(): Client{
        val firstName = binding.editTextFirstName.text.toString()
        val lastName = binding.editTextLastName.text.toString()
        val hotelName = binding.editTextHotelName.text.toString()
        val tripNumber = binding.editTextTripNumber.text.toString().toInt()
        return Client(firstName,lastName,tripNumber,hotelName)
    }

    private fun getNewClientMap(): Map<String, Any>{
        val firstName = binding.editTextNewFirstName.text.toString()
        val lastName = binding.editTextNewLastName.text.toString()
        val hotelName = binding.editTextNewHotelName.text.toString()
        val tripNumber = binding.editTextNewTripNumber.text.toString()
        val map = mutableMapOf<String, Any>()
        if (firstName.isNotEmpty()){
            map["firstName"] = firstName
        }
        if (lastName.isNotEmpty()){
            map ["lastName"] = lastName
        }
        if(tripNumber.isNotEmpty()){
            map["trip"] = tripNumber.toInt()
        }
        if(hotelName.isNotEmpty()){
            map["hotelName"] = hotelName
        }
        return map
    }

    private fun subscribeToRealtimeUpdates() {
        clientCollectionRef.addSnapshotListener { querySnapshot, firebaseFirestoreException ->
            firebaseFirestoreException?.let {
                Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                return@addSnapshotListener
            }
            querySnapshot?.let {
                val sb = StringBuilder()
                for(document in it) {
                    val person = document.toObject<Client>()
                    sb.append("$person\n")
                }
                binding.textViewClients.text = sb.toString()
            }
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
        retrieveClients()
    }

    private fun retrieveClients() = CoroutineScope(Dispatchers.IO).launch {
        try {
            val querySnapshot = clientCollectionRef.get().await()
            val stringBuilder = StringBuilder()
            for (document in querySnapshot.documents){
                val client = document.toObject<Client>()
                stringBuilder.append("$client\n")
            }
            withContext(Dispatchers.Main){
                binding.textViewClients.text = stringBuilder.toString()
            }
        } catch (e: Exception){
            withContext(Dispatchers.Main){
                Toast.makeText(this@AddClientActivity, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun deleteClient(client: Client) = CoroutineScope(Dispatchers.IO).launch {
        val clientQuery = clientCollectionRef
            .whereEqualTo("firstName", client.firstName)
            .whereEqualTo("lastName", client.lastName)
            .whereEqualTo("trip", client.trip)
            .whereEqualTo("hotelName", client.hotelName)
            .get().await()
        if (clientQuery.documents.isNotEmpty()) {
            for (document in clientQuery) {
                try {
                    clientCollectionRef.document(document.id).delete()
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@AddClientActivity, e.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun updateClient(client: Client, newClientMap: Map<String, Any>) = CoroutineScope(Dispatchers.IO).launch {
        val clientQuery = clientCollectionRef
            .whereEqualTo("firstName", client.firstName)
            .whereEqualTo("lastName", client.lastName)
            .whereEqualTo("trip", client.trip)
            .whereEqualTo("hotelName", client.hotelName)
            .get().await()
        if (clientQuery.documents.isNotEmpty()) {
            for (document in clientQuery) {
                try {
                    clientCollectionRef.document(document.id).set(
                        newClientMap,
                        SetOptions.merge()
                    )
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@AddClientActivity, e.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}