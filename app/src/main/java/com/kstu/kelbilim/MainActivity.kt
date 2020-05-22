package com.kstu.kelbilim

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.kstu.kelbilim.ui.home.HomeFragment
import com.kstu.kelbilim.utils.LoadingAlert
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var alert: LoadingAlert
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(null)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_schedule, R.id.navigation_card,  R.id.navigation_notification, R.id.navigation_profile))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id){
                R.id.navigation_home_detail -> hideBottomNav()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        showBottomNav()
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        showBottomNav()
    }
    private fun hideBottomNav (){
        nav_view.visibility = View.GONE
    }

    private fun showBottomNav (){
        nav_view.visibility = View.VISIBLE
    }
}
