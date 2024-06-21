package com.android.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


data class Correo (val de: String, val asunto: String, val texto: String)

class AdaptadorCorreo (
    private val datos: MutableList<Correo>,
    private val clickListener: (Correo) -> Unit):
    RecyclerView.Adapter<AdaptadorCorreo.CorreoViewHolder>()
{

    class CorreoViewHolder(val item : View): RecyclerView.ViewHolder(item)
    {
        val lblDe = item.findViewById(R.id.LblDe) as TextView
        val lblAsunto = item.findViewById(R.id.LblAsunto) as TextView

        fun bindCorreo(correo: Correo)
        {
            lblDe.text = correo.de
            lblAsunto.text = correo.asunto
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CorreoViewHolder {

        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem_correo, parent, false) as LinearLayout

        return CorreoViewHolder(item)
    }

    override fun onBindViewHolder(holder: CorreoViewHolder, position: Int) {

        val correo = datos[position]

        holder.bindCorreo(correo)

        holder.item.setOnClickListener { clickListener(correo) }
    }

    override fun getItemCount() = datos.size
}