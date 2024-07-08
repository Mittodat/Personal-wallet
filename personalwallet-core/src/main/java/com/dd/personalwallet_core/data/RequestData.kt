package com.dd.personalwallet_core.data

import com.google.gson.annotations.SerializedName

data class RequestData(
    @SerializedName("Id")
    val id: String ?= null
)
