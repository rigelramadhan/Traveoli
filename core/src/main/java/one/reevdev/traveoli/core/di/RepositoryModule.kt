package one.reevdev.traveoli.core.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import one.reevdev.traveoli.core.data.datasource.local.LocalDataSource
import one.reevdev.traveoli.core.data.repository.ProfileRepositoryImpl
import one.reevdev.traveoli.core.data.repository.TravelRepositoryImpl
import one.reevdev.traveoli.core.domain.repository.ProfileRepository
import one.reevdev.traveoli.core.domain.repository.TravelRepository
import javax.inject.Singleton

@Module(includes = [DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideTravelRepository(travelRepositoryImpl: TravelRepositoryImpl): TravelRepository

    @Binds
    abstract fun provideProfileRepository(profileRepositoryImpl: ProfileRepositoryImpl): ProfileRepository
}