package com.ebits.beadie.di

import android.content.Context
import androidx.room.Room
import com.ebits.beadie.data.database.BeadDao
import com.ebits.beadie.data.database.BeadieDatabase
import com.ebits.beadie.data.database.UserDao
import com.ebits.beadie.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): BeadieDatabase {
        return Room.databaseBuilder(
            appContext,
            BeadieDatabase::class.java,
            Constant.DB_NAME
        ).build()
    }

    @Provides
    fun provideUserDao(db: BeadieDatabase): UserDao = db.userDao

    @Provides
    fun provideBeadDao(db: BeadieDatabase): BeadDao = db.beadDao
}