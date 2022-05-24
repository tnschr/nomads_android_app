package com.example.nomadsapp.domain.repository

import com.example.nomadsapp.domain.dao.RecommendedTripDao
import com.example.nomadsapp.domain.dao.TravelAgencyDao
import com.example.nomadsapp.domain.dao.TripPackageDao

class NomadsRepositoryImpl(
    private val travelAgencyDao: TravelAgencyDao,
    private val recommendedTripDao: RecommendedTripDao,
    private val tripPackageDao: TripPackageDao
): NomadsRepository{

    override val travelAgency: TravelAgencyDao
        get() = travelAgencyDao

    override val recommendedTrip: RecommendedTripDao
        get() = recommendedTripDao

    override val tripPackage: TripPackageDao
        get() = tripPackageDao

}