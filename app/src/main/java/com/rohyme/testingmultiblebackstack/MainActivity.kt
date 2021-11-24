package com.rohyme.testingmultiblebackstack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val navHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.nav_host_container) as NavHostFragment }
    val navController: NavController by lazy { navHostFragment.navController }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupActionBarWithNavController(navController, AppBarConfiguration(setOf(R.id.testingFragmentA1,R.id.testingFragmentB1,R.id.testingFragmentC1)))
        findViewById<BottomNavigationView>(R.id.bottomNavigationView).apply {
            setupWithNavController(navController)
        }


    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.apply {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        navController.handleDeepLink(intent)
    }
}