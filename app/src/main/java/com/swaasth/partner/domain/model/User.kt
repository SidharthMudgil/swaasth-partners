package com.swaasth.partner.domain.model

import com.swaasth.partner.common.enums.Gender

data class User(
    val id: String,
    val name: String,
    val phone: String,
    val email: String,
    val sex: Gender,
    val dob: Long,
    val image: String,
)
