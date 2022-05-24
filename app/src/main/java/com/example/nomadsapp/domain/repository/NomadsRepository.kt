package com.example.nomadsapp.domain.repository

import com.example.nomadsapp.domain.dao.RecommendedTripDao
import com.example.nomadsapp.domain.dao.TravelAgencyDao
import com.example.nomadsapp.domain.dao.TripPackageDao

interface NomadsRepository {

    val travelAgency: TravelAgencyDao

    val recommendedTrip: RecommendedTripDao

    val tripPackage: TripPackageDao
}