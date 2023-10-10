package one.reevdev.traveoli.core.data.datasource.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Destination")
data class DestinationEntity(
    @PrimaryKey(autoGenerate = true)
    val destinationId: String,
    val name: String,
    val description: String? = null,
    val imageUrl: String? = null,
    val imageLocal: Int? = null,
)
