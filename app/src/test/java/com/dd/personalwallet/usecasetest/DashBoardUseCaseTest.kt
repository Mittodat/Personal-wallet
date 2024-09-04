package com.dd.personalwallet.usecasetest

import com.dd.personalwallet_core.data.WeatherData
import com.dd.personalwallet_core.domain.Result
import com.dd.personalwallet_core.domain.repository.DashBoardRepository
import com.dd.personalwallet_core.domain.usecase.DashBoardUseCase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import javax.inject.Inject

@HiltAndroidTest
class DashBoardUseCaseTest {

    @Inject
    lateinit var dashBoardUseCase: DashBoardUseCase

    @Mock
    lateinit var dashBoardRepository: DashBoardRepository

    @get: Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun `invoke should return data when repository call is successful`() = runBlocking {
        val lat = 12.2
        val lon = 31.3

        val expectResult = Result.Success(WeatherData(WeatherData.Coord("10.20","100.332")))
        Mockito.`when`(dashBoardRepository.getDataFromRemote(lat, lon, "dadad")).thenReturn(expectResult)

        // Act
        val result = dashBoardUseCase

        // Assert
        assertEquals(expectResult, result)
    }
}