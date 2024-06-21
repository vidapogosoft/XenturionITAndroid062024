package com.android.demo2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import androidx.recyclerview.widget.*

import android.util.Log

class MainActivity : AppCompatActivity() {

    private lateinit var recView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recView = findViewById(R.id.recView1)

        val datos = MutableList(50) { i -> Titular("Titulo $i", "Subtítulo Item $i")}

        val adaptador = AdaptadorTitulares (datos){
            Log.i("DemoRecView", "Pulsado el elemento ${it.titulo}")
        }

        recView.setHasFixedSize(true)

        //1. Linear Layout Manager
        recView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        recView.itemAnimator = DefaultItemAnimator()

        recView.adapter = adaptador
    }
}