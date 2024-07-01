package com.datafast.callactivityv2

import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Actividad2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2)

        //Tomar datos que vienen de otra actividad

        val param = intent.extras
        val dato = param?.getString("dirweb")

        val web = findViewById<WebView>(R.id.wb1)
        web.loadUrl("https://${dato}")


        val btn2 = findViewById<Button>(R.id.btnsalir)

        btn2.setOnClickListener{
            finish();
        }
    }

}