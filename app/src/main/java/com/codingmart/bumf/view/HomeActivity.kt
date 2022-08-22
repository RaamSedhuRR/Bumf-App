package com.codingmart.bumf.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.codingmart.bumf.R
import com.codingmart.bumf.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var  binding : ActivityHomeBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
        binding.bottomNavMenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    replaceFragment(HomeFragment())
                }
                R.id.search -> {
                    replaceFragment(SearchFragment()) }
                R.id.profile -> {
                    replaceFragment(ProfileFragment())           }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(binding.homeFrameLayout.id,fragment).commit()
        }

    }
}