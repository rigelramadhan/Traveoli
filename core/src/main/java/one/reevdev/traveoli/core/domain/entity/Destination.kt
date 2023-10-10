package one.reevdev.traveoli.core.domain.entity

data class Destination(
    val destinationId: String,
    val name: String,
    val description: String? = null,
    val imageUrl: String? = null,
    val imageLocal: Int? = null,
)
