package one.reevdev.traveoli.core.domain.entity

import one.reevdev.traveoli.core.data.datasource.local.entity.ActivityEntity
import java.time.LocalDate
import java.time.LocalTime

data class Activity(
    val activityId: Int,
    val tripId: String,
    val name: String,
    val date: LocalDate? = null,
    val time: LocalTime? = null,
    val duration: Int? = null,
    val notes: String? = null,
)

fun Activity.toEntity(): ActivityEntity {
    return ActivityEntity(
        activityId = activityId,
        tripId = tripId,
        name = name,
//        date = date,
//        time = time,
        duration = duration,
        notes = notes
    )
}
