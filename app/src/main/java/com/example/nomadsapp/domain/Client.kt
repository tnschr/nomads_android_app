package com.example.nomadsapp.domain

data class Client(
    var firstName: String = "",
    var lastName: String = "" ,
    var trip: Int = -1,
    var hotelName: String = ""
)