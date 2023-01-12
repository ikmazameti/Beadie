package com.ebits.beadie.ui.walkthrough

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.ebits.beadie.R

/**
 * Walkthrough inspired by
 * https://rrtutors.com/tutorials/android-onboarding-screens-with-viewpager
 * https://androidapps-development-blogs.medium.com/walkthrough-onboarding-first-time-users-screen-in-android-studio-using-viewpager-and-viewpager-2-c77d0542970f
 * https://www.youtube.com/watch?v=COZ3j8Dwlog
 * https://github.com/BoltUIX/Android-Animation-Walkthrough-Onboarding-App-Intro-Screen-02
 */
class WalkThroughHostFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_host_through_walk, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentList = arrayListOf(FirstFragment(), SecondFragment(), ThirdFragment())
        val viewpager = getView()?.findViewById<ViewPager2>(R.id.walk_through_host)
        viewpager?.adapter = ViewPagerAdapter(fragmentList, childFragmentManager, lifecycle)
    }
}

class ViewPagerAdapter(screens: ArrayList<Fragment>, fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
    private val allScreens = screens;

    override fun getItemCount(): Int = allScreens.size

    override fun createFragment(position: Int): Fragment = allScreens[position]
}