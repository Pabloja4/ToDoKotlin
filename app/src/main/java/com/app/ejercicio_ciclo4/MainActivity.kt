package com.app.ejercicio_ciclo4

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private var edtUsername : EditText?=null
    private var edtPasswordAuthentication : TextInputEditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        edtUsername=findViewById(R.id.edtUsername)
        edtPasswordAuthentication=findViewById(R.id.edtPasswordAuthentication)
    }

    fun onLogin(botonLogin: View) {

        var username: String=edtUsername!!.text.toString()

        if(edtUsername!!.text.toString()=="LVS@correo.com")
        {
            if(edtPasswordAuthentication!!.text.toString()=="1234")
            {

                val negativeButton={_:DialogInterface, _:Int->}
                val positiveButton={dialog:DialogInterface, which:Int->
                    val intent= Intent(this,WelcomeActivity::class.java)
                    startActivity(intent)
                }

                val dialog=AlertDialog.Builder(this)
                    .setTitle(getString(R.string.text_welcome))
                    .setMessage("user: " + username)
                    .setPositiveButton("ok", positiveButton)
                    .setNegativeButton("Cancel", negativeButton)
                    .create()
                    .show()
            }
            else
            {
                val dialog=AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage(getString(R.string.errorpassword))
                    .create()
                    .show()

            }
        }
        else
        {
            val dialog=AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(getString(R.string.erroruser))
                .create()
                .show()

            Toast.makeText(this, getString(R.string.erroruser), Toast.LENGTH_LONG)
                .show()
        }
    }


        fun onRegister(view: View){
            val intent= Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }


}