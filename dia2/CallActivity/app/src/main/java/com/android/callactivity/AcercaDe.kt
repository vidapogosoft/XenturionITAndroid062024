package com.android.callactivity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AcercaDe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acerca_de)

        val boton2 = findViewById<Button>(R.id.BtnSalir)

        boton2.setOnClickListener {

            finish();
        }

    }

}