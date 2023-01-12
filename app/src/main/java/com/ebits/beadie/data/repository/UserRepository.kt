package com.ebits.beadie.data.repository

import com.ebits.beadie.data.database.UserDao
import com.ebits.beadie.data.model.User


class UserRepository(private val dao: UserDao) {

    val users = dao.getAllUsers()

    suspend fun insert(user: User) {
        return dao.insert(user)
    }

    suspend fun getUserName(userName: String): User? {
        return dao.getUsername(userName)
    }
}