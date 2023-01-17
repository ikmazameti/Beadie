package com.ebits.beadie.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * Represents the products eg. beads & jewelries that this
 * application sells.
 *
 * @property productId
 * @property productName
 * @property productPrice
 * @property productPhotoUrl
 * @property productDescription
 */
@Parcelize
@Entity(tableName = "product")
data class Product(
    @PrimaryKey(autoGenerate = true) var productId: Int = 0,
    @ColumnInfo(name = "product_name") var productName: String,
    @ColumnInfo(name = "product_price") var productPrice: Double,
    @ColumnInfo(name = "product_photo_Ulr") var productPhotoUrl: String,
    @ColumnInfo(name = "product_description") var productDescription: String,
) : Parcelable


