package one.reevdev.traveoli.core.data.datasource.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.time.LocalDate
import java.time.LocalTime

@Entity(tableName = "Activity")
data class ActivityEntity(
    @PrimaryKey(autoGenerate = true)
    val activityId: String,
    val tripId: String,
    val name: String,
    val date: LocalDate,
    val time: LocalTime,
    val duration: Int,
    val notes: String? = null,
)

data class TripAndActivity(
    @Embedded
    val trip: TripEntity,

    @Relation(
        parentColumn = "tripId",
        entityColumn = "tripId",
    )
    val activities: List<ActivityEntity>
)
