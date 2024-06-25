package com.android.alertdialog

import android.content.DialogInterface
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
    }

    val PositiveButtonClick = { dialog: DialogInterface, which: Int ->

        Toast.makeText(applicationContext,"Mi mensaje SI", Toast.LENGTH_SHORT).show()
    }

    val NegativeButtonClick = { dialog: DialogInterface, which: Int ->

        Toast.makeText(applicationContext,"Mi mensaje NO", Toast.LENGTH_SHORT).show()
    }

    fun BasicAlert(view: View)
    {
        var builder = AlertDialog.Builder(this)

        with(builder)
        {
            setTitle("Android Alert Basic")
            setMessage("Nueva alerta")
            setPositiveButton("OK", DialogInterface.OnClickListener(function = PositiveButtonClick))
            setNegativeButton("Cancelar", NegativeButtonClick)
            show()
        }

    }
}