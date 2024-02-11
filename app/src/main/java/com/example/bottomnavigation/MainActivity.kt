package com.example.bottomnavigation

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottomnavigation.databinding.ActivityMainBinding
import com.example.bottomnavigation.fragments.FragmentExplore
import com.example.bottomnavigation.fragments.FragmentProfile
import com.example.bottomnavigation.fragments.FragmentTrend

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(FragmentExplore())
        //The color of the icon changes to the selected state
        binding.bottomNav.selectedItemId = R.id.btn_nav_explore

        binding.bottomNav.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.btn_nav_explore -> {
                    replaceFragment(FragmentExplore())
                }

                R.id.btn_nav_trend -> {
                    replaceFragment(FragmentTrend())
                }

                R.id.btn_nav_Profile -> {
                    replaceFragment(FragmentProfile())
                }
            }

            true
        }

        binding.bottomNav.setOnItemReselectedListener {
            /*
            If we click on an item several times, the command inside it will be executed according to the number of clicks by the user.
            In order to prevent this event, we call this function.
            Because we don't want the event item to be clicked again, we don't put anything in this function .
             */
        }

    }

    fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main, fragment)
        transaction.commit()
    }
}