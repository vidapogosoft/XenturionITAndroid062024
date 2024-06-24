package com.android.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et1=findViewById<EditText>(R.id.et1)
        val et2=findViewById<EditText>(R.id.et2)
        val tvresultado=findViewById<TextView>(R.id.tvresultado)
        val btnoperar=findViewById<Button>(R.id.btnoperacion)

        val lista = arrayOf("sumar", "restar", "multiplicar", "dividir")
        val sp1 = findViewById<Spinner>(R.id.sp1)

        val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista)
        //valores al spinner
        sp1.adapter = adaptador

        btnoperar.setOnClickListener {

            when(sp1.selectedItem.toString())
            {
                "sumar" -> tvresultado.text = "Resultado: ${et1.text.toString().toInt() + et2.text.toString().toInt()}"
                "restar" -> tvresultado.text = "Resultado: ${et1.text.toString().toInt() - et2.text.toString().toInt()}"
                "multiplicar" -> tvresultado.text = "Resultado: ${et1.text.toString().toInt() * et2.text.toString().toInt()}"
                "dividir" -> tvresultado.text = "Resultado: ${et1.text.toString().toInt() / et2.text.toString().toInt()}"
            }

        }


    }
}