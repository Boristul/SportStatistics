package com.sports.sportstatistics.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sports.sportstatistics.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navController = findNavController(R.id.am_nav_host_fragment).apply {
            addOnDestinationChangedListener { _, destination, _ ->
                title = destination.label
            }
        }

        findViewById<BottomNavigationView>(R.id.am_navigation).setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    navController.navigate(R.id.action_global_homeFragment)
                    true
                }
                R.id.menu_athletes -> {
                    navController.navigate(R.id.action_global_athletesFragment)
                    true
                }
                R.id.menu_teams -> {
                    navController.navigate(R.id.action_global_teamsFragment)
                    true
                }
                else -> false
            }
        }
    }
}
