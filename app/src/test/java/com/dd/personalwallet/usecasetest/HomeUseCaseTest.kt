package com.dd.personalwallet.usecasetest

import com.dd.personalwallet.data.CareEmployee
import com.dd.personalwallet.domain.repository.HomeRepository
import com.dd.personalwallet_core.domain.Result
import com.dd.personalwallet.domain.useCase.HomeUseCase
import com.dd.personalwallet_core.domain.Error
import io.mockk.clearMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
class HomeUseCaseTest {

    private lateinit var getHomeUseCase: HomeUseCase

    private val homeRepository: HomeRepository = mockk()

    @BeforeEach
    fun setUp() {
        getHomeUseCase = HomeUseCase(homeRepository)

    }

    @Test
    fun `invoke should return data when repository call is successful`() = runTest {

        val fakeEmployee = listOf(CareEmployee(name = "dat", age = 18, detail = "lam viec sieng nang"))
        coEvery { homeRepository.getCareEmployees() } returns Result.Success(fakeEmployee)

        //when

        val result = getHomeUseCase.getCareEmployees()

        //then

        var isSuccess = false
        result.onSuccess {
            isSuccess = true
        }

        assert(isSuccess)

        coVerify { homeRepository.getCareEmployees()}

    }

    @Test
    fun `invoke should return data when repository call is fail`() = runTest {
        coEvery { homeRepository.getCareEmployees() } returns Result.Failure(Error(1))

        //when

        val result = getHomeUseCase.getCareEmployees()

        //then
        var isFailure = false
        result.onFailure {
            isFailure = true
            assert(it is Error)
        }

        assert(isFailure)
    }

    @AfterEach
    fun testDown() {
        clearMocks(homeRepository)
    }
}