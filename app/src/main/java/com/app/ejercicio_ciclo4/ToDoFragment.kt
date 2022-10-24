package com.app.ejercicio_ciclo4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ToDoFragment : Fragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmento= inflater.inflate(R.layout.fragment_to_do, container, false)
        val btnDetail1: Button=fragmento.findViewById(R.id.btn_detail_1)
        val btnDetail2: Button=fragmento.findViewById(R.id.btn_detail_2)
        val btnDetail3: Button=fragmento.findViewById(R.id.btn_detail_3)
        btnDetail1.setOnClickListener(View.OnClickListener {
            val datos = Bundle()
            datos.putString("tarea", "Go to the grocery store")
            datos.putString("hora", "10:00am")
            datos.putString("lugar", "D1")
            activity?.getSupportFragmentManager()?.beginTransaction()?.setReorderingAllowed(true)
                ?.replace(R.id.fcvToDo,DetailFragment::class.java,datos,"detail")
                ?.addToBackStack("")
                ?.commit()

        })

        btnDetail2.setOnClickListener(View.OnClickListener {
            val datos = Bundle()
            datos.putString("tarea", "Buy potatoes")
            datos.putString("hora", "11:00am")
            datos.putString("lugar", "Exito")
            activity?.getSupportFragmentManager()?.beginTransaction()?.setReorderingAllowed(true)
                ?.replace(R.id.fcvToDo,DetailFragment::class.java,datos,"detail")
                ?.addToBackStack("")
                ?.commit()

        })

        btnDetail3.setOnClickListener(View.OnClickListener {
            val datos = Bundle()
            datos.putString("tarea", "Buy vegetables")
            datos.putString("hora", "9:00am")
            datos.putString("lugar", "Olimpica")
            activity?.getSupportFragmentManager()?.beginTransaction()?.setReorderingAllowed(true)
                ?.replace(R.id.fcvToDo,DetailFragment::class.java,datos,"detail")
                ?.addToBackStack("")
                ?.commit()

        })
        return fragmento
    }
}