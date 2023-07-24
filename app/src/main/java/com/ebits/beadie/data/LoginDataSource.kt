package com.ebits.beadie.data

import com.ebits.beadie.data.model.User
import java.io.IOException
import java.util.*

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
// */
//class LoginDataSource {
//
//    fun login(username: String, password: String): Result<User> {
//        return try {
//            // TODO: handle loggedInUser authentication
//            val fakeUser = User(UUID.randomUUID().toString(), "Jane Doe")
//            Result.Success(fakeUser)
//        } catch (e: Throwable) {
//            Result.Error(IOException("Error logging in", e))
//        }
//    }
//
//    fun logout() {
//        // TODO: revoke authentication
//    }
//}