package com.swaasth.partner.common.datatype

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import kotlin.math.abs

data class Date(
    private val timeInMillis: Long
) {
    val date by lazy {
        LocalDateTime.ofInstant(Instant.ofEpochMilli(timeInMillis), ZoneOffset.UTC)
    }

    val DATE: Int
    val DAY: Int
    val YEAR: Int
    val MONTH: Int

    init {
        DAY = date.dayOfWeek.value
        DATE = date.dayOfMonth + 1
        MONTH = date.monthValue
        YEAR = date.year
    }

    fun getApproximateDifferenceInUnits(date: Date): String {
        val differenceInDays = ChronoUnit.DAYS.between(this.date, date.date)

        return when {
            differenceInDays < 1 -> {
                val hours = ChronoUnit.HOURS.between(date.date, this.date)
                "$hours ${if (hours == 1L) "hour" else "hours"}"
            }

            differenceInDays < 7 -> {
                "$differenceInDays ${if (differenceInDays > 1) "days" else "day"}"
            }

            differenceInDays < 28 -> {
                val weeks = differenceInDays / 7
                "$weeks ${if (weeks > 1) "weeks" else "week"}"
            }

            differenceInDays < 365 -> {
                val months = differenceInDays / 28
                "$months ${if (months > 1) "months" else "month"}"
            }

            else -> {
                val years = differenceInDays / 365
                if (years > 1) {
                    "$years years"
                } else {
                    "1 year"
                }
            }
        }
    }

    fun yearDifference(date: Date): Int {
        return abs(date.YEAR - this.YEAR)
    }

    fun compareWithToday(): Int {
        val now = LocalDateTime.now()

        return when {
            now.isAfter(date) -> -1
            now.isBefore(date) -> 1
            else -> 0
        }
    }

    fun formattedDate(
        pattern: String = "dd-MM-yyyy"
    ): String {
        return DateTimeFormatter.ofPattern(pattern).format(date)
    }

    operator fun invoke(timeInMillis: Long) = Date(timeInMillis)
}