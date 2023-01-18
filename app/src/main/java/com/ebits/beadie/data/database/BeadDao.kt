package com.ebits.beadie.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ebits.beadie.data.model.Product
import kotlinx.coroutines.flow.Flow

/**
 * This class contains methods that define your interaction
 * with the database
 *
 */
//@Dao
//interface BeadDao {
//    @Insert
//    suspend fun insert(product: Product)
//
//    @Delete
//    suspend fun delete(product: Product)
//
//    @Query("SELECT * FROM Bead ORDER BY userId DESC")
//    fun getAllBeads(): Flow<List<Product>>
//
//    @Query("SELECT * FROM Bead WHERE user_name LIKE :userName")
//    suspend fun getBeadName(beadName: String): Product?
//}