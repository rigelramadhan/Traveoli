package one.reevdev.traveoli.core.domain.entity

import java.time.LocalDate
import java.time.LocalTime

data class Activity(
    val activityId: String,
    val tripId: String,
    val name: String,
    val date: LocalDate,
    val time: LocalTime,
    val duration: Int,
    val notes: String? = null,
)
