package com.ebits.beadie.ui

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.ebits.beadie.R
import com.ebits.beadie.utils.Constant.WALK_THROUGH_FINISHED
import com.ebits.beadie.utils.Constant.WALK_THROUGH_STATUS
import androidx.navigation.fragment.findNavController

/**
 * Show splash screen for three seconds.
 */
class SplashFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_splash, container, false)


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            if (onBoardingFinished()) findNavController().navigate(R.id.action_splash_to_home)
            else findNavController().navigate(R.id.action_splash_to_walkThrough)
        }, 3000)
    }


    /**
     * Retrieve the boolean value of walkthrough status
     * @return true on success and false if otherwise
     */
    private fun onBoardingFinished(): Boolean =
        requireActivity().getSharedPreferences(WALK_THROUGH_STATUS, Context.MODE_PRIVATE)
            .getBoolean(WALK_THROUGH_FINISHED, false)


}