package com.example.nomadsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nomadsapp.databinding.FragmentRecommendedTripsBinding

class RecommendedTripFragment: Fragment() {

    //val arrayList = ArrayList<RecommendedTrip>()

    var binding: FragmentRecommendedTripsBinding?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecommendedTripsBinding.inflate(layoutInflater)
        return inflater.inflate(R.layout.fragment_recommended_trips,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val trips =  mutableListOf(
            RecommendedTrip("Αθήνα - Βελιγράδι","10-6-22","360"
            ))

        /* trips.add(RecommendedTrip("Αθήνα - Βελιγράδι","10-6-22","360"))
         trips.add(RecommendedTrip("Αθήνα - Μαρόκο","13-6-22","630"))
         trips.add(RecommendedTrip("Θεσσαλονίκη - Βερολίνο","25-7-22","340"))
         trips.add(RecommendedTrip("Θεσσαλονίκη - Λονδίνο","19-6-22","400"))
         trips.add(RecommendedTrip("Αθήνα - Βουδαπέστη","1-8-22","430"))
         trips.add(RecommendedTrip("Αθήνα - Σκόπια","15-7-22","520"))
         trips.add(RecommendedTrip("Αθήνα - Κέρκυρα","11-8-22","710"))
         trips.add(RecommendedTrip("Θεσσαλονίκη - Κωνσταντινούπολη","8-6-22","300"))
         trips.add(RecommendedTrip("Θεσσαλονίκη - Σκιάθος","3-7-22","270"))
         trips.add(RecommendedTrip("Θεσσαλονίκη - Τίρανα","2-8-22","400"))
 */
        val adapter = RecommendedTripsAdapter(trips,layoutInflater)
        binding!!.recyclerViewRecommendedTrips.adapter = adapter
    }
}