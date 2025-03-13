package com.dd.personalwallet.domain.useCase

import com.dd.personalwallet.data.CareEmployee
import com.dd.personalwallet.data.ShoppingBanner
import com.dd.personalwallet_core.data.WeatherData
import com.dd.personalwallet_core.domain.Result
import com.dd.personalwallet.domain.repository.IHomeRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val homeRepository: IHomeRepository):
    IHomeUseCase {

    override suspend fun getDataRemote(lat: Double, lon: Double, apiKey: String): Result<WeatherData> =
        homeRepository.getDataFromRemote(lat, lon, apiKey)

    override suspend fun getCareEmployees(): Result<List<CareEmployee>> =
        homeRepository.getCareEmployees()

    override suspend fun getBannerList(): Result<List<ShoppingBanner>> =
        homeRepository.getBannerList()
}

interface IHomeUseCase {
    suspend fun getDataRemote(lat: Double, lon: Double, apiKey: String): Result<WeatherData>
    suspend fun getCareEmployees(): Result<List<CareEmployee>>
    suspend fun getBannerList(): Result<List<ShoppingBanner>>
}
