package com.example.composetutorial.network.api

import com.example.composetutorial.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {

    @GET("api/users/{id}")
    suspend fun singleUser(@Path("id") id: Int?): Response<User>
}