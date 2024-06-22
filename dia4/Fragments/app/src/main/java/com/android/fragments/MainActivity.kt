package com.android.fragments

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val frgListado = supportFragmentManager.findFragmentById(R.id.frgListado) as FragmentListado

        frgListado.setCorreosListener {

            val frgDetalle: Fragment? = supportFragmentManager.findFragmentById(R.id.FrgDetalle)

            if (frgDetalle != null)
            {
                (frgDetalle as FragmentDetalle).mostrarDetalle(it.texto)
            }
            else{

                val i = Intent(this, DetalleActivity::class.java)

                i.putExtra(DetalleActivity.Extra_texto, it.texto)
                startActivity(i)

            }
        }
    }
}