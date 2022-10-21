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
            datos.putString("Task", "Go to de grocety store")
            datos.putString("Time", "10:00am")
            datos.putString("Place", "D1")

            activiy?.getSupportFragmentManager()

        })
        return fragmento
    }
}