package com.ebits.beadie.network

import com.ebits.beadie.data.model.UserResponse
import com.ebits.beadie.utils.Constant.BASE_URL
import retrofit2.Call
import retrofit2.http.*

/**
 * The ApiService interface defines the contract for the API endpoints.
 */
interface ApiService {

    /**
     * User Registration API
     *
     * @param actions The endpoint for user registration (e.g., "registeruser").
     * @param apiKey The API key used for authentication.
     * @param username The username (email) of the user to be registered.
     * @param firstName The first name of the user to be registered.
     * @param lastName The last name of the user to be registered.
     * @param password The password of the user to be registered.
     * @return Call<UserResponse> A Retrofit Call object that represents the asynchronous request for user registration.
     */
    @FormUrlEncoded
    @POST(BASE_URL)
    suspend fun registerUser(
        @Field("actions") actions: String,
        @Field("apikey") apiKey: String,
        @Field("usname") username: String,
        @Field("firstname") firstName: String,
        @Field("lastname") lastName: String,
        @Field("pwd") password: String,
    ): Call<UserResponse>

    /**
     * User Login API
     *
     * @param login The User object containing login details (e.g., username and password).
     * @return Call<UserResponse> A Retrofit Call object that represents the asynchronous request for user login.
     *
     * Note: This method uses the "suspend" modifier, which means it can be called from a coroutine.
     */
    @FormUrlEncoded
    @POST("login")
    suspend fun loginUser(
        @Field("actions") actions: String,
        @Field("apikey") apiKey: String,
        @Field("usname") username: String,
        @Field("pwd") password: String,
        @Field("cipher") cipher: String,

        ): Call<UserResponse>
}



