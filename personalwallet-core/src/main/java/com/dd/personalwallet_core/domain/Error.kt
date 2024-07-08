package com.dd.personalwallet_core.domain

import com.dd.personalwallet_core.iinterface.IError

data class Error(override val errorCode: Int = 0, val message: String? = null, val throwable: Throwable? = null) :
    IError {
    override fun toString(): String {
        return "Error $errorCode $message ${throwable?.message}"
    }
}