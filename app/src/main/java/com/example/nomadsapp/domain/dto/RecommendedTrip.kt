package com.example.nomadsapp.domain.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.nomadsapp.domain.converters.TripType
import com.example.nomadsapp.domain.converters.TripTypeConverter

@Entity(tableName = "recommendedTrip")
class RecommendedTrip {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "trip_id")
    var trip_id: Int? = null

    @ColumnInfo(name = "city")
    var city: String = ""

    @ColumnInfo(name = "country")
    var country: String = ""

    @ColumnInfo(name = "duration")
    var duration: Int? = null

    @ColumnInfo(name = "type")
    var type: TripType = TripType.PLANE

    override fun toString(): String {
        return "$trip_id - $city - $country - $duration - $type"
    }
}