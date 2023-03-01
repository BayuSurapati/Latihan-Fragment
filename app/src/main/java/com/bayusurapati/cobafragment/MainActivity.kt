package com.bayusurapati.cobafragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.bayusurapati.cobafragment.fragment.AccountFragment
import com.bayusurapati.cobafragment.fragment.DashboardFragment
import com.bayusurapati.cobafragment.fragment.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val accountFragment = AccountFragment()
        val dashboardFragment = DashboardFragment()
        val settingsFragment = SettingsFragment()

        makeCurrentFragment(accountFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottmNav)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.akun_menu -> makeCurrentFragment(accountFragment)
                R.id.seting_menu -> makeCurrentFragment(settingsFragment)
                R.id.dashboard -> makeCurrentFragment(dashboardFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_bottomNav, fragment)
            commit()
        }
    }
}