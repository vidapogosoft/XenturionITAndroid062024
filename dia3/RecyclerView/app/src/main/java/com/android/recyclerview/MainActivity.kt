package com.android.recyclerview

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recView  : RecyclerView

    private lateinit var BtnIns  : Button
    private lateinit var BtnDel  : Button
    private lateinit var BtnMov  : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        BtnIns = findViewById(R.id.BtnIns)
        BtnDel = findViewById(R.id.BtnDel)
        BtnMov = findViewById(R.id.BtnMov)

        recView = findViewById(R.id.RecView1)

        val datos = MutableList(50) { i -> Titular("Titulo $i", "Subtitulo Item $i")}

        val adaptador = AdaptadorTitulares (datos){
            Log.i("DemoRecView", "Pulsando el elemento ${it.titulo}")
        }

        recView.setHasFixedSize(true)

        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        recView.itemAnimator = DefaultItemAnimator()

        recView.adapter = adaptador

        BtnIns.setOnClickListener{
            datos.add(1, Titular("Nuevo Titular", "Subtitulo Nuevo Titular"))
            adaptador.notifyItemInserted(1)
        }

        BtnDel.setOnClickListener {
            datos.removeAt(1)
            adaptador.notifyItemRemoved(1)
        }

        BtnMov.setOnClickListener {

            val titularAux = datos[1]
            datos[1] = datos[2].also {  datos[2] = datos[1]  }

            adaptador.notifyItemMoved(1,2)
        }
    }
}