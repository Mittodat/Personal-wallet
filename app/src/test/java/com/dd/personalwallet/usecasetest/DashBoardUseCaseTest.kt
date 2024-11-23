package com.dd.personalwallet.usecasetest

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dd.personalwallet.utils.DateTimeUtils
import com.dd.personalwallet_core.data.WeatherData
import com.dd.personalwallet_core.domain.Result
import com.dd.personalwallet.domain.repository.IDashboardRepository
import com.dd.personalwallet.domain.useCase.DashBoardUseCase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import javax.inject.Inject


@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class DashBoardUseCaseTest {

    @Inject
    lateinit var dashBoardUseCase: DashBoardUseCase

    @Mock
    lateinit var dashBoardRepository: IDashboardRepository

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
        val result = dashBoardUseCase.getDataRemote(lat, lon, "dadad")

        // Assert
        assertEquals(expectResult, result)
    }

    @Test
    fun `invoke should return true when it is correct emailFormat`() {
        assertTrue(DateTimeUtils.isEmailFormat("dat.nguyenvotan@gmail.com"))
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}