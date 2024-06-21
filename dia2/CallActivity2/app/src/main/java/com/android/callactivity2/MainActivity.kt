package com.android.callactivity2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et1 = findViewById<EditText>(R.id.et1)
        val btn1 = findViewById<Button>(R.id.btn1)

        btn1.setOnClickListener{

            val intent1 = Intent(this, Actividad2:: class.java)
            intent1.putExtra("dirweb",et1.text.toString())

            startActivity(intent1)
        }


    }
}