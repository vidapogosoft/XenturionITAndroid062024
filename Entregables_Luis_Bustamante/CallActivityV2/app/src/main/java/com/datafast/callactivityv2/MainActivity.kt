package com.datafast.callactivityv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var et1 = findViewById<EditText>(R.id.txt)
        var btn1 = findViewById<Button>(R.id.btnver)

        btn1.setOnClickListener{
            val intent1 = Intent(this, Actividad2::class.java)
            intent1.putExtra("dirweb",et1.text.toString())

            startActivity(intent1);
        };

    }
}