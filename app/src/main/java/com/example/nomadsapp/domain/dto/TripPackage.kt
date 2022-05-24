package com.example.nomadsapp.domain.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tripPackage",
    foreignKeys = [androidx.room.ForeignKey(
        entity = TravelAgency::class,
        parentColumns = ["id"],
        childColumns = ["agency_id"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE)])
class TripPackage {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "package_id")
    var package_id: Int? = null

    @ColumnInfo(name = "agency_id")
    var agency_id: Int? = null

    @ColumnInfo(name = "trip_id")
    var trip_id: Int? = null

    @ColumnInfo(name = "departure_date")
    var departure_date: Date? = null

    @ColumnInfo(name = "price")
    var price: String? = ""

    override fun toString(): String {
        return "$package_id - $agency_id - $trip_id - $departure_date - $price"
    }
}