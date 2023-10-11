package one.reevdev.traveoli.core.domain.repository

import kotlinx.coroutines.flow.Flow
import one.reevdev.traveoli.core.domain.entity.Profile

interface ProfileRepository {
    fun getUserProfile(username: String): Flow<Profile>
    suspend fun insertProfile(profile: Profile)
    fun deleteProfile(username: String)
}