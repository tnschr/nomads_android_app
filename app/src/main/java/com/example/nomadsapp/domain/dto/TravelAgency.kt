package com.example.nomadsapp.domain.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "travelAgency")
class TravelAgency {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "address")
    var address: String = ""

    override fun toString(): String {
        return "$id - $name - $address"
    }
}