package com.ebits.beadie.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * Represents the products eg. beads that this
 * application sells.
 *
 * @property productId
 * @property productName
 * @property productPrice
 * @property productImageUrl
 * @property productDescription
 */
@Parcelize
@Entity(tableName = "product")
data class Product(
    @PrimaryKey(autoGenerate = true) var productId: Int = 0,
    @ColumnInfo(name = "product_name") val productName: String,
    @ColumnInfo(name = "product_price") val productPrice: Double,
    @ColumnInfo(name = "product_image_Ulr") val productImageUrl: String,
    @ColumnInfo(name = "product_description") val productDescription: String,
) : Parcelable


