package com.swaasth.partner.domain.model

data class Doctor(
    val id: String,
    val name: String,
    val about: String,
    val image: String,
    val gender: String,
    val speciality: String,
    val workplace: String,
    val experience: Int,
    val patientsCount: Int,
    val rating: Double,
    val reviews: List<String>,
    val appointmentDuration: Int,
    val availableDaysOfMonth: List<Long>,
    val availableTimeRange: List<Pair<String, String>>
)