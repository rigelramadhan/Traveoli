package one.reevdev.traveoli.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import one.reevdev.traveoli.core.data.datasource.local.LocalDataSource
import one.reevdev.traveoli.core.data.datasource.local.entity.toDomain
import one.reevdev.traveoli.core.domain.entity.Profile
import one.reevdev.traveoli.core.domain.entity.toEntity
import one.reevdev.traveoli.core.domain.repository.ProfileRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : ProfileRepository {
    override fun getUserProfile(username: String): Flow<Profile> {
        return localDataSource.getUserProfile(username).map {
            it.toDomain()
        }
    }

    override suspend fun insertProfile(profile: Profile) {
        localDataSource.insertUserProfile(profile.toEntity())
    }

    override fun deleteProfile(username: String) {
        localDataSource.deleteProfile(username)
    }
}