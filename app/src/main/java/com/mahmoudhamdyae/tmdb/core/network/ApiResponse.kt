package com.mahmoudhamdyae.tmdb.core.network

import com.mahmoudhamdyae.tmdb.core.error.Failure

sealed class ApiResponse<T>(val data: T? = null, val failure: Failure? = null) {
    class Success<T>(data: T?): ApiResponse<T>(data)
    class Loading<T>: ApiResponse<T>()
    class Error<T>(failure: Failure, data: T? = null): ApiResponse<T>(data, failure)
}