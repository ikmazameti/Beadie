package com.ebits.beadie.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Represents the products eg. beads & jewelries that this
 * application sells.
 *
 * @property productId
 * @property productName
 * @property productPrice
 * @property productPhotoUrl
 * @property productDesc
 */
@Parcelize
data class Product(
    var productId: Int = 0,
    var productName: String,
    var productPrice: Double,
    var productDesc: String,
    var createdAt: Long,
    var modifiedAt: Long,
    var deletedAt: Long,
    var productPhotoUrl: String,
) : Parcelable


