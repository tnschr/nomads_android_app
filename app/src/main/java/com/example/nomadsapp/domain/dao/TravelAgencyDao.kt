package com.example.nomadsapp.domain.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.nomadsapp.domain.dto.TravelAgency
import io.reactivex.Completable

@Dao
interface TravelAgencyDao {

    @Query("SELECT * FROM travelAgency")
    fun getAll(): LiveData<List<TravelAgency>>

    @Query("SELECT * FROM travelAgency WHERE id = :id")
    fun getById(id: Int): LiveData<TravelAgency>

    @Insert
    fun insert(travelAgency: TravelAgency): Completable

    @Update
    fun update(travelAgency: TravelAgency): Completable

    @Query("DELETE FROM travelAgency WHERE id = :id")
    fun delete(id: Int): Completable
}