package com.dd.personalwallet_core.module

import com.dd.personalwallet_core.domain.repository.DashBoardRepository
import com.dd.personalwallet_core.domain.repository.IDashboardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideHomeRepository(homeRepository: DashBoardRepository): IDashboardRepository
}
