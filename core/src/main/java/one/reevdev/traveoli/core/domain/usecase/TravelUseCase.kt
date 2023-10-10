package one.reevdev.traveoli.core.domain.usecase

import kotlinx.coroutines.flow.Flow
import one.reevdev.traveoli.core.domain.entity.Activity
import one.reevdev.traveoli.core.domain.entity.Destination
import one.reevdev.traveoli.core.domain.entity.Profile
import one.reevdev.traveoli.core.domain.entity.Trip

interface TravelUseCase {
    fun getDestinations(): Flow<List<Destination>>
    fun getTrips(): Flow<List<Trip>>
    fun getUserProfile(): Flow<Profile>
    suspend fun insertDestination(destination: Destination)
    suspend fun insertTrip(trip: Trip)
    suspend fun insertActivity(activity: Activity)
    suspend fun insertActivities(activities: List<Activity>)
    suspend fun insertProfile(profile: Profile)
    fun deleteDestination(destinationId: String)
    fun deleteTrip(tripId: String)
    fun deleteActivity(activityId: String)
    fun deleteProfile(username: String)
}