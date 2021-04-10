package com.example.hicomp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class HomePage : AppCompatActivity(), View.OnClickListener {
      private lateinit var button_Tanya: ImageButton
      private lateinit var buttonBelanja: ImageButton
      private lateinit var buttondompet: Button
      private lateinit var promo : TextView
      private lateinit var toProfilebtn : ImageButton
      private lateinit var promo1 : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)

//        val navController = findNavController(R.id.nav_host_fragment1)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(setOf(
//            R.id.navigation_home, R.id.navigation_profile, R.id.navigation_shop, R.id.navigation_chat))
//        setupActionBarWithNavController(navController,
//                appBarConfiguration)
//        navView.setupWithNavController(navController)

        promo = findViewById(R.id.textView)
        button_Tanya = findViewById(R.id.buttonTanya)
        buttonBelanja = findViewById(R.id.imageButton2)
        buttondompet = findViewById(R.id.buttonwallet)
        toProfilebtn = findViewById(R.id.fotoProfile)
        promo1 = findViewById(R.id.button1)

        button_Tanya.setOnClickListener(this)
        buttonBelanja.setOnClickListener(this)
        buttondompet.setOnClickListener(this)
        toProfilebtn.setOnClickListener(this)
        promo1.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.buttonTanya -> run {
                val intentbiasa = Intent(this@HomePage, MenuTanya::class.java)
                startActivity(intentbiasa)
            }
            R.id.buttonwallet -> run {
                val intent = Intent(this@HomePage, Dompet::class.java)
                startActivity(intent)
            }
            R.id.imageButton2 -> run {
                val intent = Intent(this@HomePage,HalamanKatalog::class.java)
                startActivity(intent)
            }
            R.id.fotoProfile -> run {
                val intent = Intent(this@HomePage,profile::class.java)
                startActivity(intent)
            }
            R.id.button1 -> run {
                val intent = Intent(this@HomePage,InfoProduk::class.java)
                startActivity(intent)
            }
        }
    }

    }





