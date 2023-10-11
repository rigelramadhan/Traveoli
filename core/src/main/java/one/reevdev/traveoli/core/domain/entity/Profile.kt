package one.reevdev.traveoli.core.domain.entity

import one.reevdev.traveoli.core.data.datasource.local.entity.ProfileEntity

data class Profile(
    val firstName: String,
    val lastName: String? = null,
    val username: String,
    val email: String,
    val profilePicture: String? = null,
    val profilePictureLocal: Int? = null,
    var trips: List<Trip>? = null
)

fun Profile.toEntity(): ProfileEntity {
    return ProfileEntity(
        firstName = firstName,
        lastName = lastName,
        username = username,
        email = email,
        profilePicture = profilePicture,
        profilePictureLocal = profilePictureLocal,
    )
}
