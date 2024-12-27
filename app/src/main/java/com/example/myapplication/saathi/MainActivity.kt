//package com.example.myapplication.saathi
//
//import androidx.fragment.app.Fragment
//import com.google.android.material.bottomnavigation.BottomNavigationView
//import android.annotation.SuppressLint
//import android.content.Intent
//import android.view.MenuItem
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.ImageView
//import androidx.appcompat.app.ActionBarDrawerToggle
//import androidx.core.view.GravityCompat
//import androidx.drawerlayout.widget.DrawerLayout
//import androidx.navigation.findNavController
//import androidx.navigation.ui.AppBarConfiguration
//import androidx.navigation.ui.setupActionBarWithNavController
//import androidx.navigation.ui.setupWithNavController
//import com.example.myapplication.saathi.databinding.ActivityMainBinding
//import com.google.android.material.navigation.NavigationView
//
//private lateinit var binding: ActivityMainBinding
//private lateinit var appBarConfiguration: AppBarConfiguration
//private lateinit var RateImg: ImageView
//private lateinit var MapImg : ImageView
//private lateinit var NgoImg : ImageView
//
//class MainActivity : AppCompatActivity() {
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        MapImg = findViewById(R.id.MapImg)
//        RateImg = findViewById(R.id.RateImg)
//        NgoImg = findViewById(R.id.NgoImg)
//
//        RateImg.setOnClickListener{
//            val intent= Intent(this,LoginActivity::class.java)
//            startActivity(intent)
//        }
//
//        MapImg.setOnClickListener {
//            val intent = Intent(this,MapActivity::class.java)
//            startActivity(intent)
//        }
//
//        NgoImg.setOnClickListener {
//            val intent = Intent(this,NgoActivity::class.java)
//            startActivity(intent)
//        }
//
//
//    }
//
// }



package com.example.myapplication.saathi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.myapplication.saathi.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var RateImg: ImageView
    private lateinit var MapImg: ImageView
    private lateinit var NgoImg: ImageView
    private lateinit var drawerLayout: DrawerLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize ImageViews and DrawerLayout
        MapImg = findViewById(R.id.MapImg)
        RateImg = findViewById(R.id.RateImg)
        NgoImg = findViewById(R.id.NgoImg)
        drawerLayout = findViewById(R.id.drawer_layout)

        // Set onClickListeners for ImageViews to open respective activities
        RateImg.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        MapImg.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

        NgoImg.setOnClickListener {
            val intent = Intent(this, NgoActivity::class.java)
            startActivity(intent)
        }

        // Set up the NavigationView and its item selection listener
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { item ->
            val id = item.itemId
            when (id) {
                R.id.nav_about -> {
                    showAboutDialog() // Show about dialog
                    drawerLayout.closeDrawers() // Close the navigation drawer after selecting
                    true
                }
                else -> false // Handle other menu items if needed
            }
        }
    }

    // Function to show the "About" dialog
    private fun showAboutDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("About Saathi")
        builder.setMessage("Saathi is a helpful app to help disabled individuals navigate around with ease, exploring and connecting with NGOs and more. Created by 5 MCA students from CDAC Noida, the app aims to provide easy access to information about nearby resources and support services.")
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }
}

