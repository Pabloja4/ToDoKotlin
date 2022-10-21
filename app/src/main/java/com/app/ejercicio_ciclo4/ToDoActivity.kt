package com.app.ejercicio_ciclo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)
        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fcvToDo, ToDoFragment::class.java, null, "todo")
                .commit()

        }
    }
}