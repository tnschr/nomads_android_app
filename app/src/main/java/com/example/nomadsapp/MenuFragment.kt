package com.example.nomadsapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nomadsapp.databinding.FragmentMenuBinding
import java.lang.reflect.Array.newInstance

class MenuFragment: Fragment() {

    lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(layoutInflater)
        return binding.root

        binding.textViewRecommendedTrips.setOnClickListener {
            Log.e("test","plzzz")
          requireActivity().supportFragmentManager.beginTransaction()
              .replace(R.id.menu_container, RecommendedTripFragment()).commit()
        }
    }
}