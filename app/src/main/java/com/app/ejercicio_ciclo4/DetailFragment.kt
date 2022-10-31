package com.app.ejercicio_ciclo4

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun onUpdate(view: View) {

        val fab: View = requireActivity().findViewById(R.id.bnbUpdate)
        fab.setOnClickListener { view ->

            startActivity(Intent(requireContext(), UpdateTaskActivity::class.java))

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmento = inflater.inflate(R.layout.fragment_detail, container, false)
        var tarea = requireArguments().getString("tarea")
        var hora = requireArguments().getString("hora")
        var lugar = requireArguments().getString("lugar")
        var tvTarea: TextView = fragmento.findViewById(R.id.tvTarea)
        var tvHora: TextView = fragmento.findViewById(R.id.tvHora)
        var tvLugar: TextView = fragmento.findViewById(R.id.tvLugar)
        tvTarea.text = tarea
        tvHora.text = hora
        tvLugar.text = lugar

        return fragmento
    }


}