package one.reevdev.traveoli.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import one.reevdev.traveoli.core.data.datasource.local.database.TravelDao
import one.reevdev.traveoli.core.data.datasource.local.database.TravelDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideTravelDatabase(@ApplicationContext context: Context): TravelDatabase =
        Room.databaseBuilder(context, TravelDatabase::class.java, "travel.db")
            .fallbackToDestructiveMigration().build()

    @Provides
    fun provideTravelDao(database: TravelDatabase): TravelDao = database.getDao()
}