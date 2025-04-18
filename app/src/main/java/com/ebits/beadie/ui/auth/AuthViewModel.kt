package com.ebits.beadie.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebits.beadie.data.model.UserResponse
import com.ebits.beadie.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _userResponseLiveData = MutableLiveData<UserResponse>()
    val userResponseLiveData: LiveData<UserResponse> get() = _userResponseLiveData

    fun registerUser(
        actions: String,
        apiKey: String,
        username: String,
        firstName: String,
        lastName: String,
        password: String
    ) {
        viewModelScope.launch {
            val userResponse = userRepository.registerUser(
                actions, apiKey, username, firstName, lastName, password
            )
            _userResponseLiveData.value = userResponse
        }
    }


}
