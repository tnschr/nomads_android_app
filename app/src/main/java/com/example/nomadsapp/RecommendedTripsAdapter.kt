package com.example.nomadsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nomadsapp.databinding.RecyclerViewRecommendedTripsBinding

class RecommendedTripsAdapter(
    private var tripsItem: List<RecommendedTrip>,
    private var layoutInflater: LayoutInflater
): RecyclerView.Adapter<RecommendedTripsAdapter.RecommendedTripViewHolder>() {

    private var binding = RecyclerViewRecommendedTripsBinding.inflate(layoutInflater)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecommendedTripsAdapter.RecommendedTripViewHolder {
        return  RecommendedTripViewHolder(RecyclerViewRecommendedTripsBinding.inflate(layoutInflater,parent,false))
    }

    override fun onBindViewHolder(
        holder: RecommendedTripsAdapter.RecommendedTripViewHolder,
        position: Int
    ) {
        holder.bind(tripsItem[position])
    }

    override fun getItemCount(): Int {
        return tripsItem.size
    }

    inner class RecommendedTripViewHolder(
        var binding: RecyclerViewRecommendedTripsBinding
    ): RecyclerView.ViewHolder(binding.root){

        fun bind(tripItem: RecommendedTrip){
            with(binding){
                print(tripsItem.size)
                textViewTitle.text = tripItem.title
                textViewPrice.text = tripItem.price
                textViewDate.text = tripItem.date.toString()
            }
        }
    }
}