package com.dd.personalwallet_core.domain

import com.dd.personalwallet_core.iinterface.IResponse
import retrofit2.Response

abstract class BaseRepository {

    fun <T : Any> Response<T>.toError(): Error {
        return Error(code(), message())
    }

    fun <T : IResponse> Response<T>.toResult(): Result<T> {
        if (isSuccessful) {
            body()?.let {
                return Result.Success(it)
            }
        }
        return Result.Failure(toError())
    }
}