package com.example.nomadsapp.domain.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.nomadsapp.domain.dto.TripPackage
import io.reactivex.Completable

@Dao
interface TripPackageDao {

    @Query("SELECT * FROM tripPackage")
    fun getAll(): LiveData<List<TripPackage>>

    @Query("SELECT * FROM tripPackage WHERE package_id = :id")
    fun getById(id: Int):LiveData<TripPackage>

    @Insert
    fun insert(tripPackage: TripPackage): Completable

    @Update
    fun update(tripPackage: TripPackage): Completable

    @Query("DELETE FROM tripPackage WHERE package_id=  :id ")
    fun delete(id: Int): Completable
}