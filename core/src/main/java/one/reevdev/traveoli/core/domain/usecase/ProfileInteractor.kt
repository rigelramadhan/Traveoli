package one.reevdev.traveoli.core.domain.usecase

import kotlinx.coroutines.flow.Flow
import one.reevdev.traveoli.core.domain.entity.Profile
import one.reevdev.traveoli.core.domain.repository.ProfileRepository
import javax.inject.Inject

class ProfileInteractor @Inject constructor(
    private val profileRepository: ProfileRepository
) : ProfileUseCase {
    override fun getUserProfile(username: String): Flow<Profile> {
        return profileRepository.getUserProfile(username)
    }

    override suspend fun insertProfile(profile: Profile) {
        profileRepository.insertProfile(profile)
    }

    override fun deleteProfile(username: String) {
        profileRepository.deleteProfile(username)
    }
}