package com.dd.personalwallet_core.domain

import com.dd.personalwallet_core.iinterface.IError
import com.dd.personalwallet_core.iinterface.IResponse

sealed class Result<out T> {

    data class Success<out T>(val data: T) : Result<T>()

    data class Failure(val error: IError) : Result<Nothing>()

    inline fun onSuccess(action: (T) -> Unit): Result<T> {
        if (this is Success) {
            action(data)
        }
        return this
    }

    inline fun onFailure(action: (IError) -> Unit): Result<T> {
        if (this is Failure) {
            action(error)
        }
        return this
    }
}