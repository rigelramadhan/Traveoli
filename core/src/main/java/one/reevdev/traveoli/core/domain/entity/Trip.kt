package one.reevdev.traveoli.core.domain.entity

import one.reevdev.traveoli.core.data.datasource.local.entity.TripEntity
import java.time.LocalDate

data class Trip(
    val tripId: String,
    val userId: String,
    val destination: Destination? = null,
    val startDate: LocalDate? = null,
    val endDate: LocalDate? = null,
    val budget: Int? = null,
    val notes: String? = null,
    var activities: List<Activity>? = null
)

fun Trip.toEntity(): TripEntity {
    return TripEntity(
        tripId = tripId,
        userId = userId,
        destinationId = destination?.destinationId.orEmpty(),
        startDate = startDate,
        endDate = endDate,
        budget = budget,
        notes = notes,
    )
}
