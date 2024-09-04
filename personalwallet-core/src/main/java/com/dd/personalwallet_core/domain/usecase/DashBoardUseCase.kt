package com.dd.personalwallet_core.domain.usecase

import com.dd.personalwallet_core.data.WeatherData
import com.dd.personalwallet_core.domain.Result
import com.dd.personalwallet_core.domain.repository.IDashboardRepository
import javax.inject.Inject

class DashBoardUseCase @Inject constructor(private val dashBoardRepository: IDashboardRepository): IDashBoardUseCase {

    override suspend fun getDataRemote(lat: Double, lon: Double, apiKey: String): Result<WeatherData> =
        dashBoardRepository.getDataFromRemote(lat, lon, apiKey)
}

interface IDashBoardUseCase {
    suspend fun getDataRemote(lat: Double, lon: Double, apiKey: String): Result<WeatherData>
}
