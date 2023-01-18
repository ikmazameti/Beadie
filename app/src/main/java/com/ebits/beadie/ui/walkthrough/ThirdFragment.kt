package com.ebits.beadie.ui.walkthrough

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ebits.beadie.R
import com.ebits.beadie.utils.Constant
import com.ebits.beadie.utils.Constant.WALK_THROUGH_FINISHED

class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third, container, false)
        val finishedBtn = view.findViewById<Button>(R.id.btn_finish)

        finishedBtn.setOnClickListener {
            findNavController().navigate(R.id.action_walkThrough_to_login)
            onBoardingFinished()
        }

        return view
    }

    /**
     * Save the boolean value of walk through status in Preference
     */
    private fun onBoardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences(
            Constant.WALK_THROUGH_STATUS,
            Context.MODE_PRIVATE
        )
        val editor = sharedPref.edit()
        editor.putBoolean(WALK_THROUGH_FINISHED, true)
        editor.apply()
    }

}