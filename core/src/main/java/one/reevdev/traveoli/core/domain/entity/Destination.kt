package one.reevdev.traveoli.core.domain.entity

import one.reevdev.traveoli.core.data.datasource.local.entity.DestinationEntity

data class Destination(
    val destinationId: String,
    val name: String,
    val description: String? = null,
    val imageUrl: String? = null,
    val imageLocal: Int? = null,
)

fun Destination.toEntity(): DestinationEntity {
    return DestinationEntity(
        destinationId = destinationId,
        name = name,
        description = description,
        imageUrl = imageUrl,
        imageLocal = imageLocal,
    )
}
