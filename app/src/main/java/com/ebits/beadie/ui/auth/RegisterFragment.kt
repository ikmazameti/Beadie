package com.ebits.beadie.ui.auth


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ebits.beadie.BuildConfig
import com.ebits.beadie.R
import com.ebits.beadie.data.model.User
import com.ebits.beadie.data.model.UserResponse
import com.ebits.beadie.network.ApiClient
import com.ebits.beadie.databinding.FragmentRegisterBinding
import com.ebits.beadie.utils.isValidEmail
import com.ebits.beadie.utils.toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : Fragment() {
    val TAG: String = "RegisterFragment"
    lateinit var binding: FragmentRegisterBinding
//    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.registerBtn.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val username = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            registerUser()
        }
    }

    // User registration
    private fun registerUser() {
        GlobalScope.launch {

            ApiClient.createApiService().registerUser(
                apiKey = BuildConfig.API_KEY,
                username = "johndoe@gmail.com",
                firstName = "john",
                lastName = "doe",
                password = "space123",
                actions = "registeruser"
            ).enqueue(object : Callback<UserResponse?> {
                override fun onResponse(
                    call: Call<UserResponse?>, response: Response<UserResponse?>
                ) {
                    if (response.isSuccessful) {
                        // Registration successful, handle the response here
                        Log.d(TAG, "onResponse: ${response.body()}")
                    } else {
                        // Registration failed, handle the error here
                        Log.d(TAG, "onResponse: ${response.errorBody()}")
                    }
                }

                override fun onFailure(call: Call<UserResponse?>, t: Throwable) {
                    // Network error occurred, handle the failure here
                }
            })
        }
    }


    private fun getUserObj(): User {
        return User(
            firstName = binding.etFirstName.text.toString(),
            lastName = binding.etLastName.text.toString(),
            username = binding.etEmail.text.toString(),
            password = binding.etPassword.text.toString(),
        )
    }

    private fun validation(): Boolean {
        var isValid = true

        if (binding.etFirstName.text.isNullOrEmpty()) {
            isValid = false
            toast(getString(R.string.enter_first_name))
        }

        if (binding.etLastName.text.isNullOrEmpty()) {
            isValid = false
            toast(getString(R.string.enter_last_name))
        }



        if (binding.etEmail.text.isNullOrEmpty()) {
            isValid = false
            toast(getString(R.string.enter_email))
        } else {
            if (!binding.etEmail.text.toString().isValidEmail()) {
                isValid = false
                toast(getString(R.string.invalid_email))
            }
        }
        if (binding.etPassword.text.isNullOrEmpty()) {
            isValid = false
            toast(getString(R.string.enter_password))
        } else {
            if (binding.etPassword.text.toString().length < 8) {
                isValid = false
                toast(getString(R.string.invalid_password))
            }
        }
        return isValid
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        super.onCreateOptionsMenu(menu, inflater)
    }

}