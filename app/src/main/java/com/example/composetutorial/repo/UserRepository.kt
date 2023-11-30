package com.example.composetutorial.repo

import com.example.composetutorial.model.User
import com.example.composetutorial.network.ApiService
import com.example.composetutorial.network.api.UserService
import retrofit2.Response

object UserRepository {
    suspend fun singleUser(id: Int?): Response<User>? =
        ApiService.buildService(UserService::class.java)?.singleUser(id)

}