package com.app.ejercicio_ciclo4

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {
    private var edName : EditText?=null
    private var edLast : EditText?=null
    private var edDocument: EditText?=null
    private var edEmail: EditText?=null
    private var edPhone: EditText?=null
    private var edPass: EditText?=null
    private var chBpolicies: CheckBox?=null
    private val text_Pattern : Pattern= Pattern.compile("[a-z A-Z]*")
    private val pasword_Pattern : Pattern= Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!%*#?&])[A-Za-z\\d@\$!%*#?&]{8,}\$")
    private val email_Pattern : Pattern= Patterns.EMAIL_ADDRESS
    private val document_Pattern : Pattern= Pattern.compile("^[1-9]\\d*\$")
    private val phone_Pattern : Pattern= Pattern.compile("\\(?\\d+\\)?[-.\\s]?\\d+[-.\\s]?\\d+")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        edName=findViewById(R.id.edname)
        edLast=findViewById(R.id.edlast)
        edDocument=findViewById(R.id.eddocument)
        edEmail=findViewById(R.id.edemail)
        edPhone=findViewById(R.id.edphone)
        edPass=findViewById(R.id.edpass)
        chBpolicies=findViewById(R.id.check_policy)


    }
    fun onRegister(view: View){
        if(validarformulario())
        {
            Toast.makeText(this, "Successful registration", Toast.LENGTH_LONG).show()
        }else
        {
            Toast.makeText(this, "Registration Error", Toast.LENGTH_LONG).show()
        }
    }

    private fun validarformulario():Boolean{
        var validate=true
        val nameInput=edName!!.text.toString()
        val lastInput=edLast!!.text.toString()
        val documentInput=edDocument!!.text.toString()
        val emailInput=edEmail!!.text.toString()
        val phoneInput=edPhone!!.text.toString()
        val passInput=edPass!!.text.toString()

        if(!chBpolicies!!.isChecked)
        {
            validate=true
        }


        //        Name validation

        if(TextUtils.isEmpty(edName!!.text.toString()))
            {
                edName!!.error="Required"
                validate=false
            }else if(!text_Pattern.matcher(nameInput).matches())

            {
                edName!!.error="Invalid name"
                validate=false
            }else edName!!.error=null

        //        Last Name validation

        if(TextUtils.isEmpty(edLast!!.text.toString()))
        {
            edLast!!.error="Required"
            validate=false
        }else if(!text_Pattern.matcher(lastInput).matches())

        {
            edLast!!.error="Invalid Last Name"
            validate=false
        }else edLast!!.error=null

        // Document validation

        if(TextUtils.isEmpty(edDocument!!.text.toString()))
        {
            edDocument!!.error="Required"
            validate=false
        }else if(!document_Pattern.matcher(documentInput).matches())

        {
            edDocument!!.error="Invalid document"
            validate=false
        }else edDocument!!.error=null

        //        Password validation

            if(TextUtils.isEmpty(edPass!!.text.toString()))
            {
                edPass!!.error="Required"
                validate=false
            }else if(!pasword_Pattern.matcher(passInput).matches())

            {
                edPass!!.error="Invalid Pasword"
                validate=false

            }else edPass!!.error=null


        //        Phone validation

        if(TextUtils.isEmpty(edPhone!!.text.toString()))
        {
            edPhone!!.error="Required"
            validate=false
        }else if(!phone_Pattern.matcher(phoneInput).matches())

        {
            edPhone!!.error="Invalid number"
            validate=false

        }else edPhone!!.error=null

//      email validation

        if(TextUtils.isEmpty(edEmail!!.text.toString()))
        {
            edEmail!!.error="Required"
            validate=false
        }else if(!email_Pattern.matcher(emailInput).matches())

        {
            edEmail!!.error="Invalid email"
            validate=false

        }else edEmail!!.error=null

            return validate

    }
}