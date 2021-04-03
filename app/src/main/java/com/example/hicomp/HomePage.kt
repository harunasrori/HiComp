package com.example.hicomp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class HomePage : AppCompatActivity(), View.OnClickListener {
      private lateinit var button_Tanya: ImageButton
//    private lateinit var buttonBelanja: Button
//    private lateinit var buttondompet: Button
      private lateinit var promo : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        promo = findViewById(R.id.textView)
        button_Tanya = findViewById(R.id.buttonTanya)
//        buttonBelanja = findViewById(R.id.buttonBelanja)
//        buttondompet = findViewById(R.id.buttondompet)

        button_Tanya.setOnClickListener(this)
//        buttonBelanja.setOnClickListener(this)
//        buttondompet.setOnClickListener(this)
    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.buttonTanya -> run {
                val intentbiasa = Intent(this@HomePage, MenuTanya::class.java)
                startActivity(intentbiasa)
            }
        }
    }
}