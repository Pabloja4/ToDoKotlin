package com.app.ejercicio_ciclo4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val fab:View=findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            //Snackbar.make(view, "add",Snackbar.LENGTH_LONG)
            val intent= Intent(this,ToDoActivity::class.java)
            startActivity(intent)
        }
    }
}