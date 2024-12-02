package com.dd.personalwallet.module.usecase

import com.dd.personalwallet.domain.useCase.HomeUseCase
import com.dd.personalwallet.domain.useCase.IHomeUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun provideHomeUseCase(homeUseCase: HomeUseCase): IHomeUseCase
}
