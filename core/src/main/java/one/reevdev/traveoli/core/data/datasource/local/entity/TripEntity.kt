package one.reevdev.traveoli.core.data.datasource.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import one.reevdev.traveoli.core.domain.entity.Profile
import one.reevdev.traveoli.core.domain.entity.Trip
import java.time.LocalDate

@Entity(tableName = "Trip")
data class TripEntity(
    @PrimaryKey(autoGenerate = true)
    val tripId: Int,
    val userId: String,
    val tripName: String,
    val destinationId: Int,
//    val startDate: LocalDate? = null,
//    val endDate: LocalDate? = null,
    val budget: Int? = null,
    val notes: String? = null,
)

data class UserAndTrips(
    @Embedded
    val user: ProfileEntity,

    @Relation(
        parentColumn = "username",
        entityColumn = "userId",
    )
    val trips: List<TripEntity>
)

fun TripEntity.toDomain(destinationEntity: DestinationEntity? = null): Trip {
    return Trip(
        tripId = tripId,
        userId = userId,
        tripName = tripName,
        destination = destinationEntity?.toDomain(),
//        startDate = startDate,
//        endDate = endDate,
        budget = budget,
        notes = notes,
    )
}