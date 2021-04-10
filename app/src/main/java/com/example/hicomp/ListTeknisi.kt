package com.example.hicomp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class ListTeknisi : AppCompatActivity(), View.OnClickListener {

    private lateinit var btn_profile1 : ImageButton
    private lateinit var btn_profile2 : ImageButton
    private lateinit var btn_profile3 : ImageButton
    private lateinit var buttonBack : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_teknisi)

        btn_profile1 = findViewById(R.id.profile1)
        btn_profile2 = findViewById(R.id.profile2)
        btn_profile3 = findViewById(R.id.profile3)
        buttonBack = findViewById(R.id.backarrow)

        btn_profile1.setOnClickListener(this)
        btn_profile2.setOnClickListener(this)
        btn_profile3.setOnClickListener(this)
        buttonBack.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.profile1 -> run {
                val intentbiasa = Intent(this@ListTeknisi, Teknisi1::class.java)
                startActivity(intentbiasa)
            }
            R.id.profile2 -> run {
                val intentbiasa = Intent(this@ListTeknisi, Teknisi2::class.java)
                startActivity(intentbiasa)
            }
            R.id.profile3 -> run {
                val intentbiasa = Intent(this@ListTeknisi, Teknisi3::class.java)
                startActivity(intentbiasa)
            }
            R.id.backarrow -> run {
                val intent = Intent(this@ListTeknisi, MenuTanya::class.java)
                startActivity(intent)
            }
        }
    }
}