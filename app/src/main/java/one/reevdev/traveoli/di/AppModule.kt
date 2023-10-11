package one.reevdev.traveoli.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import one.reevdev.traveoli.core.domain.usecase.ProfileInteractor
import one.reevdev.traveoli.core.domain.usecase.ProfileUseCase
import one.reevdev.traveoli.core.domain.usecase.TravelInteractor
import one.reevdev.traveoli.core.domain.usecase.TravelUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideTravelUseCase(travelInteractor: TravelInteractor): TravelUseCase

    @Binds
    @Singleton
    abstract fun provideProfileUseCase(profileInteractor: ProfileInteractor): ProfileUseCase
}