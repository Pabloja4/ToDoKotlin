package com.app.ejercicio_ciclo4

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType{
    BASIC,
    GOOGLE
}

class WelcomeActivity : AppCompatActivity() {
    private var textemail: TextView?= null
    private var textprovider: TextView?= null
    private var btnlogOut: Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        textemail=findViewById(R.id.textemail)
        textprovider=findViewById(R.id.textprovider)

        val bundle= intent.extras
        val email=bundle?.getString("Email")
        val provider=bundle?.getString("provider")
        textemail!!.text=email
        textprovider!!.text=provider
        val prefs= getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
            prefs.putString("email",email)
            prefs.putString("provider", provider)
        btnlogOut= findViewById(R.id.btnlogoout)
        btnlogOut!!.setOnClickListener{
            val prefs= getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
            prefs.clear()
            prefs.apply()
            FirebaseAuth.getInstance().signOut()
           // onBackPressed()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val fab:View=findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            //Snackbar.make(view, "add",Snackbar.LENGTH_LONG)
            val intent= Intent(this,ToDoActivity::class.java)
            startActivity(intent)
        }


    }
    override fun onBackPressed(){
        super.onBackPressed()
        val homeIntent= Intent(this, WelcomeActivity::class.java).apply {
            putExtra("email",textemail!!.text.toString())
            putExtra("provider",textprovider!!.text.toString())
        }
        startActivity(homeIntent)

    }
}