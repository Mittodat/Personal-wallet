package com.dd.personalwallet_core.module

import com.dd.personalwallet_core.domain.usecase.DashBoardUseCase
import com.dd.personalwallet_core.domain.usecase.IDashBoardUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
     abstract fun provideHomeUseCase(homeUseCase: DashBoardUseCase): IDashBoardUseCase
}
