package com.example.nomadsapp.domain.converters

import androidx.room.TypeConverter

class TripTypeConverter {

    @TypeConverter
    fun convertTypeToString(type: TripType): String {
        return type.name
    }

    @TypeConverter
    fun convertStringToType(type: String): TripType{
        return TripType.valueOf(type)
    }
}