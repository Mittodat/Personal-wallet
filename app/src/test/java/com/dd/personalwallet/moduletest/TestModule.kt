package com.dd.personalwallet.moduletest

import com.dd.personalwallet_core.domain.repository.DashBoardRepository
import com.dd.personalwallet_core.module.RepositoryModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import org.mockito.Mockito.mock

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RepositoryModule::class]
)
object TestModule {
    @Provides
    fun providesDashBoardRepository(): DashBoardRepository {
        return mock(DashBoardRepository::class.java)
    }
}