package com.android.sqlite

import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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

        val CodPrinc = findViewById<EditText>(R.id.codigo_principal)
        val Descrip = findViewById<EditText>(R.id.descripcion)
        val Precio = findViewById<EditText>(R.id.precio)
        val Result = findViewById<TextView>(R.id.Resultado)

        val Add = findViewById<Button>(R.id.BtnGrabar)
        val Upd = findViewById<Button>(R.id.BtnUpd)
        val Del = findViewById<Button>(R.id.BtnDel)
        val Cons = findViewById<Button>(R.id.BtnCons)
        val ConsDesc = findViewById<Button>(R.id.BtnConsDesc)

        Cons.setOnClickListener {

            val admin = AdminSQLite(this, "productos", null, 1)
            val bd = admin.writableDatabase

            var fila = bd.rawQuery("select descripcion, precio, codigo_principal, estado from productos where codigo_principal = ${CodPrinc.text.toString()}", null)

            if(fila.moveToFirst())
            {

                //CodPrinc.setText(fila.getString(0))
                Descrip.setText(fila.getString(0))
                Precio.setText(fila.getString(1))
                Result.setText(fila.getString(2))
            }
            else{
                Result.setText("No existen registros para el codigo: " + "-" + CodPrinc.getText().toString())
            }

            bd.close()

        }

        ConsDesc.setOnClickListener {

            val admin = AdminSQLite(this, "productos", null, 1)
            val bd = admin.writableDatabase

            var fila = bd.rawQuery("select codigo_principal, precio, descripcion, estado from productos where descripcion like ${"'%"+Descrip.text.toString()+"%'"}", null)

            if(fila.moveToFirst())
            {

                CodPrinc.setText(fila.getString(0))
                //Descrip.setText(fila.getString(1))
                Precio.setText(fila.getString(1))
                Result.setText(fila.getString(2))
            }
            else{
                Result.setText("No existen registros para descripcion: " + "-" + Descrip.getText().toString())
            }

            bd.close()

        }

        Add.setOnClickListener {

            val admin = AdminSQLite(this, "productos", null, 1)
            val bd = admin.writableDatabase

            val registro = ContentValues()

            registro.put("codigo_principal", CodPrinc.getText().toString())
            registro.put("descripcion", Descrip.getText().toString())
            registro.put("precio", Precio.getText().toString())
            registro.put("estado", "ACTIVO")

            val save = bd.insert("productos", null, registro)
            bd.close()

            if (save > 0) {

                Result.setText(save.toString() + "-" + Descrip.getText().toString())
                Toast.makeText(this, "Registro Ingresado: " + Descrip.getText(), Toast.LENGTH_LONG)
            }
            else
            {
                Toast.makeText(this, "Error en Registro", Toast.LENGTH_LONG)
            }

            CodPrinc.setText("")
            Descrip.setText("")
            Precio.setText("")
        }

    }
}