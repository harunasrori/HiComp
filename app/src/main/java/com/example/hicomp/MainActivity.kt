package com.example.hicomp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btn_login : Button
    private lateinit var etUsername : EditText
    private lateinit var etPass : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login = findViewById(R.id.btn_login)

        btn_login.setOnClickListener(this)
    }

        override fun onClick(v: View) {
            when (v.id) {
                R.id.btn_login -> run {
                    val intentbiasa = Intent(this@MainActivity, HomePage::class.java)
                    startActivity(intentbiasa)
                }
            }
        }
    }

