package com.ebits.beadie.di

import com.ebits.beadie.ui.auth.AuthRepository
import com.ebits.beadie.ui.auth.AuthRepositoryImp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAutRepository(database: FirebaseFirestore, auth: FirebaseAuth): AuthRepository {
        return AuthRepositoryImp(auth, database)
    }
}