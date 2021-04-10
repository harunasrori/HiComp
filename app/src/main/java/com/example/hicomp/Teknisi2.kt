package com.example.hicomp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Teknisi2 : AppCompatActivity(), View.OnClickListener  {
    private lateinit var btnask : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teknisi2)

        btnask = findViewById(R.id.Askbtn)
        btnask.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val number : String = "0811174774"
        val message : String = "Hai, aku ingin berkonsultasi nih mengenai PC/Laptopku"
        when (v.id) {
            R.id.Askbtn -> run {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra("address", number)
                intent.putExtra(Intent.EXTRA_TEXT, message )
                intent.type = "text/plain"

                startActivity(Intent.createChooser(intent,"Please Select app :"))
            }
        }
    }
}