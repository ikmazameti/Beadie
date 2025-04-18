package com.ebits.beadie.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Represents the products eg. beads & jewelries that this
 * application sells.
 *
 * @property orderId
 * @property createdAt
 */
@Parcelize
data class Order(
    var orderId: Int = 0,
    @JvmField var createdAt: Long,
) : Parcelable


