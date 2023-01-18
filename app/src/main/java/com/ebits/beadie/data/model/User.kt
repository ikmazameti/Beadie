package com.ebits.beadie.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represent users of the application
 *
 * @property email
 * @property password
 */


data class User(
    var id: String = "",
    val first_name: String = "",
    val last_name: String = "",
    val email: String = "",
)