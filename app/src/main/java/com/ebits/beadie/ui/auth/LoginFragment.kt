package com.ebits.beadie.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ebits.beadie.R
import com.ebits.beadie.databinding.FragmentLoginBinding
import com.ebits.beadie.utils.*

 class LoginFragment : Fragment() {

    val TAG: String = "RegisterFragment"
    lateinit var binding: FragmentLoginBinding
//    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        observer()
//        binding.actionLogin.setOnClickListener {
//            if (validation()) {
//                viewModel.login(
//                    email = binding.etEmail.text.toString(),
//                    password = binding.etPassword.text.toString()
//                )
//            }
//        }

        binding.forgotPassword.setOnClickListener {

        }

        binding.actionRegister.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_register)
        }
    }

//    private fun observer() {
//        viewModel.login.observe(viewLifecycleOwner) { state ->
//            when (state) {
//                is UiState.Loading -> {
//                    binding.actionLogin.text = ""
//                    binding.loginProgress.show()
//                }
//                is UiState.Failure -> {
//                    binding.actionLogin.text = "Login"
//                    binding.loginProgress.hide()
//                    toast(state.error)
//                }
//                is UiState.Success -> {
//                    binding.actionLogin.text = "Login"
//                    binding.loginProgress.hide()
//                    toast(state.data)
//                    findNavController().navigate(R.id.action_login_to_home)
//                }
//            }
//        }
//    }

    private fun validation(): Boolean {
        var isValid = true

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

}