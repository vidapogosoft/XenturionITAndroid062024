package com.android.fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetalleActivity : AppCompatActivity() {

    companion object{
        val Extra_texto : String = "com.android.fragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle)

        val detalle = supportFragmentManager.findFragmentById(R.id.FrgDetalle) as FragmentDetalle

        detalle.mostrarDetalle(intent.getStringExtra(Extra_texto).toString())

    }
}