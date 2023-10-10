package one.reevdev.traveoli.core.domain.usecase

import kotlinx.coroutines.flow.Flow
import one.reevdev.traveoli.core.domain.entity.Profile

interface ProfileUseCase {
    fun getUserProfile(): Flow<Profile>
    suspend fun insertProfile(profile: Profile)
    fun deleteProfile(username: String)
}