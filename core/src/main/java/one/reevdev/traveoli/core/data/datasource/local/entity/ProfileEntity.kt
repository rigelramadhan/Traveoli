package one.reevdev.traveoli.core.data.datasource.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import one.reevdev.traveoli.core.domain.entity.Profile

@Entity(tableName = "Profile")
data class ProfileEntity(
    val firstName: String,
    val lastName: String? = null,
    @PrimaryKey
    val username: String,
    val email: String,
    val profilePicture: String? = null,
    val profilePictureLocal: Int? = null
)

fun ProfileEntity.toDomain(): Profile {
    return Profile(
        firstName = firstName,
        lastName = lastName,
        username = username,
        email = email,
        profilePicture = profilePicture,
        profilePictureLocal = profilePictureLocal
    )
}