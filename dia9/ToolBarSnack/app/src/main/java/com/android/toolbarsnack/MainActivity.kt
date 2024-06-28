package com.android.toolbarsnack

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.loader.app.LoaderManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tbar = findViewById<Toolbar>(R.id.appbar1)
        setSupportActionBar(tbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val tbcard = findViewById<Toolbar>(R.id.tbCard)
        tbcard.title = "Mi Tarjeta"
        tbcard.inflateMenu(R.menu.menu_tarjetas)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.action_opciones -> {
            Log.i("Action Bar", "Opciones 1")
            true
        }

        R.id.action_nuevo -> {
            Log.i("Action Bar", "Nuevo 2")
            true
        }

        R.id.action_buscar -> {
            Log.i("Action Bar", "Buscar 3")
            true
        }
        else ->
        {
            super.onOptionsItemSelected(item)
        }
    }

}