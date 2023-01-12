package com.ebits.beadie.data.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ebits.beadie.data.model.User
import com.ebits.beadie.utils.Constant.DB_NAME

/**
 * This class represent the actual local database in the application.
 *
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class BeadieDatabase : RoomDatabase() {
    abstract val userDao: UserDao

    companion object {
        @Volatile
        private var INSTANCE: BeadieDatabase? = null

        fun getInstance(context: Context): BeadieDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext, BeadieDatabase::class.java, DB_NAME
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}