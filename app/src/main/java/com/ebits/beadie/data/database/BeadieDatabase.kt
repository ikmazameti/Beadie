package com.ebits.beadie.data.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.ebits.beadie.data.model.Product
import com.ebits.beadie.data.model.User

/**
 * SQLite Database for storing the [Product]s and [User]s.
 */
@Database(entities = [User::class, Product::class], version = 1, exportSchema = false)
abstract class BeadieDatabase : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val beadDao: BeadDao
}