package one.reevdev.traveoli.core.domain.usecase

import kotlinx.coroutines.flow.Flow
import one.reevdev.traveoli.core.domain.entity.Activity
import one.reevdev.traveoli.core.domain.entity.Destination
import one.reevdev.traveoli.core.domain.entity.Trip
import one.reevdev.traveoli.core.domain.repository.TravelRepository
import javax.inject.Inject

class TravelInteractor @Inject constructor(
    private val travelRepository: TravelRepository
) : TravelUseCase {
    override fun getDestinations(): Flow<List<Destination>> {
        return travelRepository.getDestinations()
    }

    override fun getTrips(username: String): Flow<List<Trip>> {
        return travelRepository.getTrips(username)
    }

    override fun getActivities(tripId: Int): Flow<List<Activity>> {
        return travelRepository.getActivities(tripId)
    }

    override suspend fun insertDestination(destination: Destination) {
        travelRepository.insertDestination(destination)
    }

    override suspend fun insertTrip(trip: Trip) {
        travelRepository.insertTrip(trip)
    }

    override suspend fun insertActivity(activity: Activity) {
        travelRepository.insertActivity(activity)
    }

    override suspend fun insertActivities(activities: List<Activity>) {
        travelRepository.insertActivities(activities)
    }

    override fun deleteDestination(destinationId: Int) {
        travelRepository.deleteDestination(destinationId)
    }

    override fun deleteTrip(tripId: Int) {
        travelRepository.deleteTrip(tripId)
    }

    override fun deleteActivity(activityId: Int) {
        travelRepository.deleteActivity(activityId)
    }

}