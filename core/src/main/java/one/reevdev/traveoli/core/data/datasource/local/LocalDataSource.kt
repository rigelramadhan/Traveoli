package one.reevdev.traveoli.core.data.datasource.local

import kotlinx.coroutines.flow.Flow
import one.reevdev.traveoli.core.data.datasource.local.database.TravelDao
import one.reevdev.traveoli.core.data.datasource.local.entity.ActivityEntity
import one.reevdev.traveoli.core.data.datasource.local.entity.DestinationEntity
import one.reevdev.traveoli.core.data.datasource.local.entity.ProfileEntity
import one.reevdev.traveoli.core.data.datasource.local.entity.TripAndActivity
import one.reevdev.traveoli.core.data.datasource.local.entity.TripEntity
import one.reevdev.traveoli.core.data.datasource.local.entity.UserAndTrips
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val travelDao: TravelDao
) : TravelDao {
    override fun getDestinations(): Flow<List<DestinationEntity>> {
        return travelDao.getDestinations()
    }

    override fun getTrips(username: String): Flow<List<TripEntity>> {
        return travelDao.getTrips(username)
    }

    override fun getActivities(tripId: Int): Flow<List<ActivityEntity>> {
        return travelDao.getActivities(tripId)
    }

    override fun getTripAndActivities(username: String): Flow<List<TripAndActivity>> {
        return travelDao.getTripAndActivities(username)
    }

    override fun getUserProfile(username: String): Flow<ProfileEntity> {
        return travelDao.getUserProfile(username)
    }

    override fun getUserAndTrips(username: String): Flow<List<UserAndTrips>> {
        return travelDao.getUserAndTrips(username)
    }

    override suspend fun insertDestination(destination: DestinationEntity) {
        travelDao.insertDestination(destination)
    }

    override suspend fun insertTrip(trip: TripEntity) {
        travelDao.insertTrip(trip)
    }

    override suspend fun insertActivity(activity: ActivityEntity) {
        travelDao.insertActivity(activity)
    }

    override suspend fun insertActivity(activity: List<ActivityEntity>) {
        travelDao.insertActivity(activity)
    }

    override suspend fun insertUserProfile(profile: ProfileEntity) {
        travelDao.insertUserProfile(profile)
    }

    override fun deleteDestination(destination: DestinationEntity) {
        travelDao.deleteDestination(destination)
    }

    override fun deleteDestination(destinationId: Int) {
        travelDao.deleteDestination(destinationId)
    }

    override fun deleteActivity(activity: ActivityEntity) {
        travelDao.deleteActivity(activity)
    }

    override fun deleteActivity(activityId: String) {
        travelDao.deleteActivity(activityId)
    }

    override fun deleteTrip(trip: TripEntity) {
        travelDao.deleteTrip(trip)
    }

    override fun deleteTrip(tripId: Int) {
        travelDao.deleteTrip(tripId)
    }

    override fun deleteProfile(profile: ProfileEntity) {
        travelDao.deleteProfile(profile)
    }

    override fun deleteProfile(username: String) {
        deleteProfile(username)
    }

}