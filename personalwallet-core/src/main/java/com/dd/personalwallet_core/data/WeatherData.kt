package com.dd.personalwallet_core.data

import com.dd.personalwallet_core.iinterface.IResponse
import com.google.gson.annotations.SerializedName

data class WeatherData(
    @SerializedName("coord")
    val coord: Coord? = null,

) : IResponse {
    data class Coord(
        @SerializedName("lat")
        val lat: String?,

        @SerializedName("lon")
        val lon: String
    ): IResponse
}
