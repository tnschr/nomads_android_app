package com.example.nomadsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nomadsapp.databinding.FragmentRecommendedTripsBinding

class RecommendedTripFragment: Fragment() {

    var binding: FragmentRecommendedTripsBinding?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecommendedTripsBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val trips =  mutableListOf(
            RecommendedTrip("Αθήνα - Βελιγράδι","10-6-22","360"
            ),RecommendedTrip("Αθήνα - Μαρόκο","13-6-22","630"),
            RecommendedTrip("Θεσσαλονίκη - Βερολίνο","25-7-22","340"),
            RecommendedTrip("Αθήνα - Βελιγράδι","10-6-22","360"),
            RecommendedTrip("Θεσσαλονίκη - Λονδίνο","19-6-22","400"),
            RecommendedTrip("Αθήνα - Βουδαπέστη","1-8-22","430"),
            RecommendedTrip("Αθήνα - Σκόπια","15-7-22","520"),
            RecommendedTrip("Αθήνα - Κέρκυρα","11-8-22","710"),
            RecommendedTrip("Θεσσαλονίκη - Κωνσταντινούπολη","8-6-22","300"),
            RecommendedTrip("Θεσσαλονίκη - Σκιάθος","3-7-22","270"),
            RecommendedTrip("Θεσσαλονίκη - Τίρανα","2-8-22","400")
        )

        val adapter = RecommendedTripsAdapter(trips,layoutInflater)
        binding!!.recyclerViewRecommendedTrips.adapter = adapter
    }
}