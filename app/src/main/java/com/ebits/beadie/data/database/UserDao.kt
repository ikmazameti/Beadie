package com.ebits.beadie.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ebits.beadie.data.model.User

/**
 * This class contains methods that define your interaction
 * with the database
 *
 */
@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * FROM User ORDER BY userId DESC")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM User WHERE user_name LIKE :userName")
    suspend fun getUsername(userName: String): User?
}