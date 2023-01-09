package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val infoFragment = InfoFragment()
        val settingsFragment = SetttingsFragment()
        val dashboardFragment = DashboardFragment()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        replacefragment(infoFragment)

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.ic_dashboard ->replacefragment(dashboardFragment)
                R.id.ic_info -> replacefragment(infoFragment)
                R.id.ic_settings -> replacefragment(settingsFragment)
            }
            true
        }
    }
    private fun replacefragment(fragment: Fragment)
    {
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout,fragment  )
            transaction.commit()
        }
    }

}
