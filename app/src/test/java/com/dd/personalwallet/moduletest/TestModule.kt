package com.dd.personalwallet.moduletest

import com.dd.personalwallet.domain.repository.IDashboardRepository
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
    fun providesDashBoardRepository(): IDashboardRepository {
        return mock(IDashboardRepository::class.java)
    }
}
