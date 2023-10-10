package one.reevdev.traveoli.core.domain.entity

import java.time.LocalDate

data class Trip(
    val tripId: String,
    val userId: String,
    val destination: Destination,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val budget: Int,
    val notes: String? = null,
    val activities: List<Activity>? = null
)
