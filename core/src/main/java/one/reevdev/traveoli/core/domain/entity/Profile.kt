package one.reevdev.traveoli.core.domain.entity

data class Profile(
    val firstName: String,
    val lastName: String? = null,
    val username: String,
    val email: String,
    val profilePicture: String? = null,
    val profilePictureLocal: Int? = null,
    val trips: List<Trip>? = null
)
