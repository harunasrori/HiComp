package com.example.hicomp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.content.Intent

class MenuTanya : AppCompatActivity(), View.OnClickListener {

    private lateinit var btn_konsul : Button
    private lateinit var btn_servis : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_tanya)

        btn_konsul = findViewById(R.id.tanyaKonsul)
        btn_servis = findViewById(R.id.tanyaServis)

        btn_konsul.setOnClickListener(this)
        btn_servis.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tanyaKonsul -> run {
                val intentbiasa = Intent(this@MenuTanya, ListTeknisi::class.java)
                startActivity(intentbiasa)
            }
        }
    }
}