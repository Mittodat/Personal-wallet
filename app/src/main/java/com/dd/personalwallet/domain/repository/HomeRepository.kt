package com.dd.personalwallet.domain.repository

import com.dd.personalwallet.data.CareEmployee
import com.dd.personalwallet.data.ShoppingBanner
import com.dd.personalwallet_core.data.WeatherData
import com.dd.personalwallet_core.data.networking.HomeApi
import com.dd.personalwallet_core.domain.BaseRepository
import com.dd.personalwallet_core.domain.Result
import javax.inject.Inject

class HomeRepository @Inject constructor(private val homeApi: HomeApi): BaseRepository(),
    IHomeRepository {

    override suspend fun getDataFromRemote(lat: Double, lon: Double, apiKey: String): Result<WeatherData> {
        val response = homeApi.getCurrentWeather(lat, lon, apiKey)

        if (response.isSuccessful) {
            return Result.Success(response.body()!!)
        }

        return Result.Failure(response.toError())
    }

    override suspend fun getCareEmployees(): Result<List<CareEmployee>> {
        return Result.Success(CareEmployee.fatory)
    }

    override suspend fun getBannerList(): Result<List<ShoppingBanner>> {
        return Result.Success(ShoppingBanner.fatory)
    }
}

interface IHomeRepository {
    suspend fun getDataFromRemote(lat: Double, lon: Double, apiKey: String): Result<WeatherData>
    suspend fun getCareEmployees(): Result<List<CareEmployee>>
    suspend fun getBannerList(): Result<List<ShoppingBanner>>
}