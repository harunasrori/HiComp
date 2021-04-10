package com.example.hicomp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var  btn_register : Button
    private lateinit var  buttontoLogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register = findViewById(R.id.btn_regist)
        buttontoLogin = findViewById(R.id.toLogin)

        btn_register.setOnClickListener(this)
        buttontoLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.toLogin -> run {
                val intent = Intent(this@RegisterActivity,LoginActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_regist -> run {
                val intent = Intent(this@RegisterActivity,HomePage::class.java)
                startActivity(intent)
            }
        }
    }


}