package com.ebits.beadie.data.repo

import com.ebits.beadie.data.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers(): Flow<List<User>>

 }