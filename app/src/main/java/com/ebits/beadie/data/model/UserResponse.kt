package com.ebits.beadie.data.model


import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("data") val data: Data,
    @SerializedName("msg") val message: String
)

data class Data(
    @SerializedName("CLNT_ACTOR_CODE") val clientActorCode: String,
    @SerializedName("CLNT_ACTOR_NAME") val clientActorName: String,
    @SerializedName("CLNT_APIKEY") val clientApiKey: String,
    @SerializedName("CLNT_CIPHER") val clientCipher: String,
    @SerializedName("CLNT_CODE") val clientCode: String,
    @SerializedName("CLNT_CONTACT_PERSON") val clientContactPerson: String,
    @SerializedName("CLNT_COUNTRY_CODE") val clientCountryCode: String,
    @SerializedName("CLNT_COUNTRY_NAME") val clientCountryName: String,
    @SerializedName("CLNT_COUNTRY_PREFIX") val clientCountryPrefix: String,
    @SerializedName("CLNT_CREATED_DATE") val clientCreatedDate: CLNTCREATEDDATE,
    @SerializedName("CLNT_EMAIL") val clientEmail: String,
    @SerializedName("CLNT_ENTRY_TYPE") val clientEntryType: String,
    @SerializedName("CLNT_FIRSTNAME") val clientFirstName: String,
    @SerializedName("CLNT_IMAGE") val clientImage: String,
    @SerializedName("CLNT_LASTLOGIN_DATE") val clientLastLoginDate: CLNTLASTLOGINDATE,
    @SerializedName("CLNT_LASTNAME") val clientLastName: String,
    @SerializedName("CLNT_MOBILE_APP_REGISTRATION") val clientMobileAppRegistration: String,
    @SerializedName("CLNT_NUM") val clientNumber: String,
    @SerializedName("CLNT_PASSWORD") val clientPassword: String,
    @SerializedName("CLNT_PHONE_CODE") val clientPhoneNumber: String,
    @SerializedName("CLNT_REFCODE") val clientRefCode: String,
    @SerializedName("CLNT_RSADDRESS") val clientResidentialAddress: String,
    @SerializedName("CLNT_SOURCE") val clientSource: String,
    @SerializedName("CLNT_STATUS") val clientStatus: String,
    @SerializedName("CLNT_USERNAME") val clientUsername: String,
    @SerializedName("CLNT_VERIFY_EMAIL") val clientVerifyEmail: String,
    @SerializedName("_id") val id: Id
)

data class CLNTCREATEDDATE(
    @SerializedName("date") val clientCreatedDate: Date
)

data class Date(
    @SerializedName("numberLong") val numberLong: String
)

data class CLNTLASTLOGINDATE(
    @SerializedName("date") val clientLastLoginDate: Date
)

data class Id(
    @SerializedName("oid") val oid: String
)
