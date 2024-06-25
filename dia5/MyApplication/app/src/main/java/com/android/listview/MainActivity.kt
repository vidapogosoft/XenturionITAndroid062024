package com.android.listview

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tv1 = findViewById<TextView>(R.id.lv1)
        val list1 = findViewById<ListView>(R.id.lstv1)

        val paises = arrayOf("Ecuador","Argentina","Chile","Mexico","USA","Canada","Colombia","Peru")

        val equipos = arrayOf("Barcelona - Emelec - LDU","River - Boca Jr - Racing","Colo Colo - La U","PUMAS - Necaxa","LA GALAXY","NA","DIM","SPORTING CRISTAL")

        val adapt = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paises)
        list1.adapter = adapt

        list1.setOnItemClickListener { AdapterView, view, i, l ->

            tv1.text = "Equipos: ${ equipos[i]}"
        }

    }
}