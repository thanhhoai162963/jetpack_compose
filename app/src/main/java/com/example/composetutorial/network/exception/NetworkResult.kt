package com.example.composetutorial.network.exception

sealed class NetworkResult<T> {
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Error<T>(val exp: Exception, val error: T) : NetworkResult<T>()
}

