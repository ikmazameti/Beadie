package com.ebits.beadie.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represent users of the application - [Beadie]
 *
 * @property userId
 * @property firstName
 * @property lastName
 * @property userName
 * @property password
 */

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true) var userId: Int = 0,
    @ColumnInfo(name = "first_name") var firstName: String,
    @ColumnInfo(name = "last_name") var lastName: String,
    @ColumnInfo(name = "user_name") var userName: String,
    @ColumnInfo(name = "password_text") var password: String
)
