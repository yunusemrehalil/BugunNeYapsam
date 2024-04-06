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

    fun navigateToFragment(fragment: Fragment): Boolean {
        fragmentManager.beginTransaction()
            .replace(R.id.layout_container, fragment)
            .commit()
        return true
    }

    fun bottomNavToFragment(menuItem: MenuItem): Boolean {
        val fragment = when (menuItem.itemId) {
            R.id.bottom_nav_home -> HomeFragment()
            R.id.bottom_nav_suggestions -> SuggestionsFragment()
            R.id.bottom_nav_profile -> ProfileFragment()
            R.id.bottom_nav_bookmarks -> BookmarksFragment()
            else -> return false
        }
        fragmentManager.beginTransaction()
            .replace(R.id.layout_container, fragment)
            .commit()
        return true
    }
}