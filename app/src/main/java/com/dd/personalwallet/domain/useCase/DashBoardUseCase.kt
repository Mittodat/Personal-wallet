package com.dd.personalwallet.domain.useCase

import com.dd.personalwallet.data.CareEmployee
import com.dd.personalwallet.data.ShoppingBanner
import com.dd.personalwallet_core.data.WeatherData
import com.dd.personalwallet_core.domain.Result
import com.dd.personalwallet.domain.repository.IDashboardRepository
import javax.inject.Inject

class DashBoardUseCase @Inject constructor(private val dashBoardRepository: IDashboardRepository):
    IDashBoardUseCase {

    override suspend fun getDataRemote(lat: Double, lon: Double, apiKey: String): Result<WeatherData> =
        dashBoardRepository.getDataFromRemote(lat, lon, apiKey)

    override suspend fun getCareEmployees(): Result<List<CareEmployee>> =
        dashBoardRepository.getCareEmployees()

    override suspend fun getBannerList(): Result<List<ShoppingBanner>> =
        dashBoardRepository.getBannerList()
}

interface IDashBoardUseCase {
    suspend fun getDataRemote(lat: Double, lon: Double, apiKey: String): Result<WeatherData>
    suspend fun getCareEmployees(): Result<List<CareEmployee>>
    suspend fun getBannerList(): Result<List<ShoppingBanner>>
}
