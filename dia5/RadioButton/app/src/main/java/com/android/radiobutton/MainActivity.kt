package com.android.radiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et1=findViewById<EditText>(R.id.et1)
        val et2=findViewById<EditText>(R.id.et2)

        val tvsuma = findViewById<TextView>(R.id.tvsuma)
        val tvresta = findViewById<TextView>(R.id.tvresta)

        val rbsuma = findViewById<RadioButton>(R.id.rbsuma)
        val rbresta = findViewById<RadioButton>(R.id.rbresta)

        val btnoperar = findViewById<Button>(R.id.btnoperacion)

        btnoperar.setOnClickListener {

            var resultado = "";

            if (rbsuma.isChecked) {
                resultado = "Suma = ${et1.text.toString().toInt() + et2.text.toString().toInt()}"
                tvsuma.text = resultado;
            }

            if (rbresta.isChecked) {
                resultado = "Resta = ${et1.text.toString().toInt() - et2.text.toString().toInt()}"
                tvresta.text = resultado;
            }

        }
    }
}