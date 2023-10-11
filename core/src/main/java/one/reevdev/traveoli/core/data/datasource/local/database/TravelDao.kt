package one.reevdev.traveoli.core.data.datasource.local.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import one.reevdev.traveoli.core.data.datasource.local.entity.ActivityEntity
import one.reevdev.traveoli.core.data.datasource.local.entity.DestinationEntity
import one.reevdev.traveoli.core.data.datasource.local.entity.ProfileEntity
import one.reevdev.traveoli.core.data.datasource.local.entity.TripAndActivity
import one.reevdev.traveoli.core.data.datasource.local.entity.TripEntity
import one.reevdev.traveoli.core.data.datasource.local.entity.UserAndTrips

@Dao
interface TravelDao {
    @Query("SELECT * FROM destination")
    fun getDestinations(): Flow<List<DestinationEntity>>

    @Query("SELECT * FROM trip WHERE userId = :username")
    fun getTrips(username: String): Flow<List<TripEntity>>

    @Query("SELECT * FROM activity WHERE tripId = :tripId")
    fun getActivities(tripId: Int): Flow<List<ActivityEntity>>

    @Transaction
    @Query("SELECT * FROM trip WHERE userId = :username")
    fun getTripAndActivities(username: String): Flow<List<TripAndActivity>>

    @Query("SELECT * FROM profile WHERE username = :username")
    fun getUserProfile(username: String): Flow<ProfileEntity>

    @Transaction
    @Query("SELECT * FROM profile WHERE username = :username")
    fun getUserAndTrips(username: String): Flow<List<UserAndTrips>>

    @Insert(entity = DestinationEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDestination(destination: DestinationEntity)

    @Insert(entity = TripEntity::class, onConflict = OnConflictStrategy.ABORT)
    suspend fun insertTrip(trip: TripEntity)

    @Insert(entity = ActivityEntity::class, onConflict = OnConflictStrategy.NONE)
    suspend fun insertActivity(activity: ActivityEntity)

    @Insert(entity = ActivityEntity::class, onConflict = OnConflictStrategy.NONE)
    suspend fun insertActivity(activity: List<ActivityEntity>)

    @Insert(entity = ProfileEntity::class, onConflict = OnConflictStrategy.ABORT)
    suspend fun insertUserProfile(profile: ProfileEntity)

    @Delete(entity = DestinationEntity::class)
    fun deleteDestination(destination: DestinationEntity)

    @Query("DELETE FROM destination WHERE destinationId = :destinationId")
    fun deleteDestination(destinationId: Int)

    @Delete(entity = ActivityEntity::class)
    fun deleteActivity(activity: ActivityEntity)

    @Query("DELETE FROM activity WHERE activityId = :activityId")
    fun deleteActivity(activityId: String)

    @Delete(entity = TripEntity::class)
    fun deleteTrip(trip: TripEntity)

    @Query("DELETE FROM trip WHERE tripId = :tripId")
    fun deleteTrip(tripId: Int)

    @Delete(entity = ProfileEntity::class)
    fun deleteProfile(profile: ProfileEntity)

    @Query("DELETE FROM profile WHERE username = :username")
    fun deleteProfile(username: String)
}