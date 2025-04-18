package com.ebits.beadie.data.repository

import com.ebits.beadie.data.model.UserResponse
import com.ebits.beadie.data.network.ApiService
import javax.inject.Inject


class UserRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun registerUser(
        actions: String,
        apiKey: String,
        username: String,
        firstName: String,
        lastName: String,
        password: String
    ): UserResponse {
        return apiService.registerUser(actions, apiKey, username, firstName, lastName, password)
    }


}





