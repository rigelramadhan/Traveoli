package one.reevdev.traveoli.core.data.datasource.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.time.LocalDate

@Entity(tableName = "Trip")
data class TripEntity(
    @PrimaryKey
    val tripId: String,
    val userId: String,
    val destinationId: String,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val budget: Int,
    val notes: String? = null,
)

data class UserAndTrips(
    @Embedded
    val user: ProfileEntity,

    @Relation(
        parentColumn = "userId",
        entityColumn = "userId",
    )
    val trips: List<TripEntity>
)