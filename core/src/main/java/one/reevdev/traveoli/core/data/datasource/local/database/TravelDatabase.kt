package one.reevdev.traveoli.core.data.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import one.reevdev.traveoli.core.data.datasource.local.entity.ActivityEntity
import one.reevdev.traveoli.core.data.datasource.local.entity.DestinationEntity
import one.reevdev.traveoli.core.data.datasource.local.entity.ProfileEntity
import one.reevdev.traveoli.core.data.datasource.local.entity.TripEntity

@Database(
    entities = [
        DestinationEntity::class,
        TripEntity::class,
        ActivityEntity::class,
        ProfileEntity::class
    ],
    version = 1,
)
abstract class TravelDatabase : RoomDatabase() {
    abstract fun getDao(): TravelDao
}