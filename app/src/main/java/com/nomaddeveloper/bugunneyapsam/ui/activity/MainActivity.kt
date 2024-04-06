package com.nomaddeveloper.bugunneyapsam.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nomaddeveloper.bugunneyapsam.R
import com.nomaddeveloper.bugunneyapsam.databinding.ActivityMainBinding
import com.nomaddeveloper.bugunneyapsam.ui.fragment.HomeFragment
import com.nomaddeveloper.bugunneyapsam.util.NavigationUtil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var navigationUtil: NavigationUtil
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigationUtil = NavigationUtil(supportFragmentManager)

        prepareUI()

        navigationUtil.navigateToFragment(HomeFragment())
        bottomNav.setOnItemSelectedListener {
            navigationUtil.bottomNavToFragment(it)
        }
    }

    private fun prepareUI() {
        bottomNav = binding.bottomNavActivityMain
        bottomNav.selectedItemId = R.id.bottom_nav_home
    }
}