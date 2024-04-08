package com.nomaddeveloper.bugunneyapsam.util

import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.nomaddeveloper.bugunneyapsam.R
import com.nomaddeveloper.bugunneyapsam.ui.fragment.BookmarksFragment
import com.nomaddeveloper.bugunneyapsam.ui.fragment.HomeFragment
import com.nomaddeveloper.bugunneyapsam.ui.fragment.ProfileFragment
import com.nomaddeveloper.bugunneyapsam.ui.fragment.SuggestionsFragment

class NavigationUtil(private val fragmentManager: FragmentManager) {

    private fun replaceFragment(fragment: Fragment, addToBackStack: Boolean) {
        val transaction = fragmentManager.beginTransaction()
        transaction.setCustomAnimations(
            R.anim.slide_in_right_fragment_anim,
            R.anim.slide_out_right_fragment_anim,
            R.anim.slide_in_left_fragment_anim,
            R.anim.slide_out_left_fragment_anim
        )
        transaction.replace(R.id.fragment_container, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }

    fun navigateToFragment(fragment: Fragment) {
        replaceFragment(fragment, addToBackStack = false)
    }

    fun bottomNavToFragment(menuItem: MenuItem): Boolean {
        val fragment = when (menuItem.itemId) {
            R.id.bottom_nav_home -> HomeFragment()
            R.id.bottom_nav_suggestions -> SuggestionsFragment()
            R.id.bottom_nav_profile -> ProfileFragment()
            R.id.bottom_nav_bookmarks -> BookmarksFragment()
            else -> return false
        }
        replaceFragment(fragment, addToBackStack = false)
        return true
    }
}
