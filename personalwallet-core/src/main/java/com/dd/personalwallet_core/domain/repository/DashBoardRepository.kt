package com.dd.personalwallet_core.domain.repository

import com.dd.personalwallet_core.data.ResponseData
import com.dd.personalwallet_core.data.networking.HomeApi
import com.dd.personalwallet_core.domain.BaseRepository
import com.dd.personalwallet_core.domain.Result
import javax.inject.Inject

class DashBoardRepository @Inject constructor(private val homeApi: HomeApi): BaseRepository(), IDashboardRepository {

    override suspend fun getDataFromRemote(lat: Double, lon: Double, apiKey: String): Result<ResponseData> {
        val response = homeApi.getCurrentWeather(lat, lon, apiKey)

        if (response.isSuccessful) {
            return Result.Success(response.body()!!)
        }

        return Result.Failure(response.toError())
    }
}

interface IDashboardRepository {
    suspend fun getDataFromRemote(lat: Double, lon: Double, apiKey: String): Result<ResponseData>
}