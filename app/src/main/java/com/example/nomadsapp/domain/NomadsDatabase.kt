package com.example.nomadsapp.domain

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nomadsapp.domain.dao.RecommendedTripDao
import com.example.nomadsapp.domain.dao.TravelAgencyDao
import com.example.nomadsapp.domain.dao.TripPackageDao
import com.example.nomadsapp.domain.dto.RecommendedTrip
import com.example.nomadsapp.domain.dto.TravelAgency
import com.example.nomadsapp.domain.dto.TripPackage

@Database(
    entities = [
        TravelAgency::class,
        RecommendedTrip::class,
        TripPackage::class
    ],
    version = 1
)
abstract class NomadsDatabase: RoomDatabase() {

    abstract fun travelAgency():TravelAgencyDao

    abstract fun recommendedTrip(): RecommendedTripDao

    abstract fun tripPackage(): TripPackageDao
}