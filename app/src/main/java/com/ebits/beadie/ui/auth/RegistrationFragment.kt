package com.ebits.beadie.ui.auth


import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ebits.beadie.BuildConfig
import com.ebits.beadie.R
import com.ebits.beadie.data.model.UserResponse
import com.ebits.beadie.databinding.FragmentRegistrationBinding
import com.ebits.beadie.utils.ACTION_REGISTER
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment : Fragment(R.layout.fragment_registration) {
    private val viewModel: AuthViewModel by viewModels()
    private lateinit var binding: FragmentRegistrationBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the click listener for the registration button
        binding.registerBtn.setOnClickListener {
            registerUser()
        }


        // Observe the registration response from ViewModel
        viewModel.userResponseLiveData.observe(viewLifecycleOwner) { userResponse ->
            handleRegistrationResponse(userResponse)
        }
    }


    private fun handleRegistrationResponse(userResponse: UserResponse) {
        // Handle the registration response here
        // For example, show a toast or navigate to the next screen
    }


    private fun registerUser() {
        val actions = ACTION_REGISTER
        val apiKey = BuildConfig.API_KEY
        val username = binding.etEmail.text.toString().trim()
        val firstName = binding.etFirstName.text.toString().trim()
        val lastName = binding.etLastName.text.toString().trim()
        val password = binding.etPassword.text.toString()
        val retypePassword = binding.etRetypePassword.text.toString()

        // Validate user input
        if (!validateUserInput(username, firstName, lastName, password, retypePassword)) {
            return
        }

        viewModel.registerUser(actions, apiKey, username, firstName, lastName, password)
    }

    private fun validateUserInput(
        username: String,
        firstName: String,
        lastName: String,
        password: String,
        retypePassword: String
    ): Boolean {
        // Validate email
        if (!isValidEmail(username)) {
            // Show an error message for the email EditText
            binding.tilEmail.error = getString(R.string.invalid_email)
            return false
        } else {
            // Clear the error message if the email is valid
            binding.tilEmail.error = null
        }

        // Validate first name
        if (!isValidName(firstName)) {
            // Show an error message or set an error state for the first name EditText
            binding.tilFirstName.error = getString(R.string.invalid_name)
            return false
        } else {
            binding.tilFirstName.error = null
        }

        // Validate last name
        if (!isValidName(lastName)) {
            // Show an error message or set an error state for the last name EditText
            binding.tilLastName.error = getString(R.string.invalid_name)
            return false
        } else {
            binding.tilLastName.error = null
        }

        // Validate passwords
        if (!arePasswordsMatching(password, retypePassword)) {
            // Show an error message or set an error state for the password or retypePassword EditTexts
            binding.tilRetypePassword.error = getString(R.string.invalid_password)
            return false
        } else {
            binding.tilRetypePassword.error = null
        }

        // All validations pass
        return true
    }



    /**
     * Validates a name.
     *
     * This function takes a name as input and checks if it meets the validation criteria.
     * The name should not be empty or blank (after trimming), and it should contain only letters (no numbers or special characters).
     *
     * @param name The name to be validated (first name or last name).
     * @return true if the name is valid, false otherwise.
     */
    private fun isValidName(name: String): Boolean {
        // Trim the name to remove leading and trailing whitespace
        val trimmedName = name.trim()

        // Check if the trimmed name is not empty
        if (trimmedName.isEmpty()) {
            return false
        }

        // Check if the name contains only letters
        val namePattern = Regex("^[a-zA-Z]+\$")
        return trimmedName.matches(namePattern)
    }

    /**
     * Checks whether two passwords match each other and satisfy specific criteria.
     *
     * This function takes two password strings as input and checks if they match each other
     * and if they both satisfy the password requirements defined by the regex pattern.
     *
     * @param password The first password to be validated.
     * @param retypePassword The second password (re-entered) to be validated.
     * @return true if both passwords match and meet the password requirements, false otherwise.
     */
    private fun arePasswordsMatching(password: String, retypePassword: String): Boolean {
        // Check if the passwords match
        if (password != retypePassword) {
            return false
        }

        // Check if the password satisfies the regex pattern
        val passwordPattern = Regex("^(?=.*[0-9])(?=.*[a-zA-Z]).{6,}\$")
        return password.matches(passwordPattern)
    }

    /**
     * Validates an email address using a regular expression pattern.
     *
     * This function checks whether the provided email address is in a valid format. It uses a regular expression pattern
     * to validate the email address, ensuring it follows the common email address format.
     *
     * @param email The email address to be validated.
     * @return true if the email is in a valid format, false otherwise.
     */
    private fun isValidEmail(email: String): Boolean {
        // Check if the email is valid using a regex pattern for email validation
        val emailPattern = Regex("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,})+\$")
        return email.matches(emailPattern)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        super.onCreateOptionsMenu(menu, inflater)
    }

}