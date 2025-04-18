package com.ebits.beadie.ui.walkthrough

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.ebits.beadie.R

class FirstFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val nextBtn = view.findViewById<Button>(R.id.btn_next)
        val viewPager =  activity?.findViewById<ViewPager2>(R.id.walk_through_host)

        nextBtn.setOnClickListener {
            viewPager?.currentItem = 1
        }
        return view
    }


}