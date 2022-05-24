package com.example.nomadsapp.domain.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.nomadsapp.domain.dto.RecommendedTrip
import io.reactivex.Completable

@Dao
interface RecommendedTripDao {

    @Query("SELECT * FROM recommendedTrip")
    fun getAll(): LiveData<List<RecommendedTrip>>

    @Query("SELECT * FROM recommendedTrip WHERE trip_id = :id")
    fun getById(id: Int): LiveData<RecommendedTrip>

    @Insert
    fun insert(recommendedTrip: RecommendedTrip): Completable

    @Update
    fun update(recommendedTrip: RecommendedTrip): Completable

    @Query("DELETE FROM recommendedTrip WHERE trip_id = :id")
    fun delete(id: Int): Completable
}