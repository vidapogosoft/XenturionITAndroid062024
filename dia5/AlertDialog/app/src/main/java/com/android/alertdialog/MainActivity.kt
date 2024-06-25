package com.android.alertdialog

import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.WindowInsetsCompat
import java.util.Arrays
import android.widget.LinearLayout
import android.widget.EditText

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

    fun IconAlert(view: View)
    {
        var builder = AlertDialog.Builder(this)

        with(builder)
        {
            setTitle("Android Icon Alert")
            setMessage("Nueva alerta")

            setPositiveButton("OK", null)
            setNegativeButton("Cancelar",  null)

            setIcon(resources.getDrawable(android.R.drawable.ic_dialog_alert))

            setPositiveButtonIcon(resources.getDrawable(android.R.drawable.ic_media_play, theme))
        }

        val alerta = builder.create()
        alerta.show()

        val Boton = alerta.getButton(DialogInterface.BUTTON_POSITIVE)
        with(Boton)
        {
            setBackgroundColor(Color.BLUE)
            setPadding(0,0,20,0)
            setTextColor(Color.WHITE)
        }

    }

    fun ItemsAlert(view: View)
    {
        val items = arrayOf("Android", "Swift","Flutter","Xamarin","Net Maui","React Native")

        var builder = AlertDialog.Builder(this)

        with(builder)
        {
            setTitle("Android List Alert")

            setItems(items) { dialog, wich ->
                Toast.makeText(applicationContext, items[wich] + "fue seleccionado: "
                    ,  Toast.LENGTH_SHORT ).show()
            }

            setPositiveButton("OK", PositiveButtonClick)

            show()
        }
    }

    fun ChoiceAlert(view: View)
    {
        val items = arrayOf("Android", "Swift","Flutter","Xamarin","Net Maui","React Native")

        val SelectedList = ArrayList<Int>()

        var builder = AlertDialog.Builder(this)

        builder.setTitle("Lista de opción multiple")
        builder.setMultiChoiceItems(items, null)
        { dialog, wich, isCheked ->
            if(isCheked)
            {
                SelectedList.add(wich)
            }
            else if(SelectedList.contains(wich))
            {
                SelectedList.remove( Integer.valueOf(wich) )
            }
        }

        builder.setPositiveButton("Aceptar")
        { dialogInterface, i ->

            val selectedString = ArrayList<String>()

            for(j in SelectedList.indices)
            {
                selectedString.add(items[SelectedList[j]])
            }

            Toast.makeText(applicationContext, "Items seleccionados: "
                    + Arrays.toString(selectedString.toTypedArray()), Toast.LENGTH_LONG).show()

        }

        builder.show()

    }

    fun StyleAlert(view: View)
    {
        var builder = AlertDialog.Builder(ContextThemeWrapper(this, android.R.style.Holo_SegmentedButton))

        with(builder)
        {
            setTitle("Android Alert con style de android theme")
            setMessage("Nueva alerta")
            setPositiveButton("OK", DialogInterface.OnClickListener(function = PositiveButtonClick))
            setNegativeButton("Cancelar", NegativeButtonClick)
            show()
        }
    }

    fun CustomStyleAlert(view: View)
    {
        var builder = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AlertDialogCustom))

        with(builder)
        {
            setTitle("Android Alert con style custom")
            setMessage("Nueva alerta")
            setPositiveButton("OK", DialogInterface.OnClickListener(function = PositiveButtonClick))
            setNegativeButton("Cancelar", NegativeButtonClick)
            show()
        }
    }

    fun withButtonCentered(view: View){

        val alertDialog = AlertDialog.Builder(this).create()
        alertDialog.setTitle("Tutulo de la Alerta")
        alertDialog.setMessage("Alerta con acciones")

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "De Acuerdo")
        {
                dialog, wich -> dialog.dismiss()
        }

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar")
        {
                dialog, wich -> dialog.dismiss()
        }

        alertDialog.show()

        val btnPositiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
        val btnNegativeButton = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE)

        val layoutParameter = btnPositiveButton.layoutParams as LinearLayout.LayoutParams
        layoutParameter.weight = 10f

        btnPositiveButton.layoutParams = layoutParameter
        btnNegativeButton.layoutParams = layoutParameter

    }

    fun withEditText(view: View){

        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater

        builder.setTitle("Inflater - Edit Text")

        val dialogLayout = inflater.inflate(R.layout.alert_dialog_with_edittext, null)
        val editText = dialogLayout.findViewById<EditText>(R.id.editText)

        builder.setView(dialogLayout)
        builder.setPositiveButton("De Acuerdo")
        {
                dialogInterface, i -> Toast.makeText(applicationContext, "EditText is ${editText.text}", Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }


}