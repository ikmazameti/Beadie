package com.ebits.beadie.ui.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebits.beadie.BuildConfig
import com.ebits.beadie.data.model.UserResponse
import com.ebits.beadie.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {

    val registerUserResponse = MutableLiveData<UserResponse>()
    val errorMessage = MutableLiveData<String>()
    val isShowProgress = MutableLiveData<Boolean>()
    val expressionToSearch = MutableLiveData("")


    fun registerUser() {
        viewModelScope.launch {
            val response = apiService.registerUser(
                apiKey = BuildConfig.API_KEY,
                username = "johndoe@gmail.com",
                firstName = "john",
                lastName = "doe",
                password = "space123",
                actions = "registeruser"
            )
        }
    }

}