package one.reevdev.traveoli.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single
import one.reevdev.traveoli.core.data.datasource.local.LocalDataSource
import one.reevdev.traveoli.core.data.datasource.local.entity.toDomain
import one.reevdev.traveoli.core.domain.entity.Activity
import one.reevdev.traveoli.core.domain.entity.Destination
import one.reevdev.traveoli.core.domain.entity.Trip
import one.reevdev.traveoli.core.domain.entity.toEntity
import one.reevdev.traveoli.core.domain.repository.TravelRepository
import javax.inject.Inject
import javax.inject.Singleton

class TravelRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : TravelRepository {
    override fun getDestinations(): Flow<List<Destination>> {
        return localDataSource.getDestinations().map {
            it.map { destination ->
                destination.toDomain()
            }
        }
    }

    override fun getTrips(username: String): Flow<List<Trip>> {
        return localDataSource.getTrips(username).map {
            it.map { trip ->
                trip.toDomain().copy(activities = getActivities(trip.tripId).first())
            }
        }
    }

    override fun getActivities(tripId: Int): Flow<List<Activity>> {
        return localDataSource.getActivities(tripId).map {
            it.map { activity ->
                activity.toDomain()
            }
        }
    }

    override suspend fun insertDestination(destination: Destination) {
        localDataSource.insertDestination(destination.toEntity())
    }

    override suspend fun insertTrip(trip: Trip) {
        localDataSource.insertTrip(trip.toEntity())
    }

    override suspend fun insertActivity(activity: Activity) {
        localDataSource.insertActivity(activity.toEntity())
    }

    override suspend fun insertActivities(activities: List<Activity>) {
        localDataSource.insertActivity(activities.map { it.toEntity() })
    }

    override fun deleteDestination(destinationId: Int) {
        localDataSource.deleteDestination(destinationId)
    }

    override fun deleteTrip(tripId: Int) {
        localDataSource.deleteTrip(tripId)
    }

    override fun deleteActivity(activityId: Int) {
        deleteActivity(activityId)
    }
}