package com.ebits.beadie.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Represent users of the application
 */

@Parcelize
data class User(
    @SerializedName("firstname") val firstName: String? = "",
    @SerializedName("othernames") val lastName: String? = "",
    @SerializedName("usname") val username: String? = "",//same as email address
    @SerializedName("pwd") val password: String? = "",
 ) : Parcelable