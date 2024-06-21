package com.android.callactivity2

import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Actividad2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2)

        //tomar esos datos de entrada q vienen de otro activity

        val param = intent.extras
        val dato = param?.getString("dirweb")

        val web = findViewById<WebView>(R.id.wv1)
        web.loadUrl("https://${dato}")

        val btn2 = findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener {
            finish();
        }

    }


}