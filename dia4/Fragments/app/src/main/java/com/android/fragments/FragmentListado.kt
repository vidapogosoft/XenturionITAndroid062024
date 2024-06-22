package com.android.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentListado : Fragment() {

    private lateinit var listado : RecyclerView
    var listener : CorreosListener? = null

    private val datos = MutableList(10)
    {i -> Correo("Persona $i","Asunto del correo $i"
        ,"texto del correo $i") }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.fragment_listado, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        listado = requireView().findViewById(R.id.LstListado)

        val adaptador = AdaptadorCorreo(datos)
        { listener?.onCorreoSeleccionado(it) }

        listado.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)

        listado.adapter = adaptador
    }

    fun setCorreosListener(listen: CorreosListener)
    {
        listener = listen
    }

    fun setCorreosListener(seleccion : (Correo) -> Unit)
    {
        listener = object:CorreosListener{
            override fun onCorreoSeleccionado(correo: Correo) {
                seleccion(correo)
            }
        }
    }

}