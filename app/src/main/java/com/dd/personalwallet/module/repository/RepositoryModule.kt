package com.dd.personalwallet.module.repository

import com.dd.personalwallet.domain.repository.HomeRepository
import com.dd.personalwallet.domain.repository.IHomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideHomeRepository(homeRepository: HomeRepository): IHomeRepository
}
