package com.jdg.proyredes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class registro : AppCompatActivity() {

    lateinit var usersDBHelper : UsersDBHelper

    private lateinit var correo2: EditText
    private lateinit var contra2: EditText
    private lateinit var telef2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        correo2 = findViewById(R.id.correoIng)
        contra2 = findViewById(R.id.passIng)
        telef2 = findViewById(R.id.telefono)

        usersDBHelper = UsersDBHelper(this)

        var but:Button = findViewById(R.id.RegPacomp)

        but.setOnClickListener() {
            var correo = correo2.text.toString()
            var contra = contra2.text.toString()
            var telef = telef2.text.toString()
            usersDBHelper.insertUser(UserModel(correo = correo,contra = contra,telef = telef))
            //clear all edittext s
            limpiarDatos()
            val intent = Intent(this,pag_inicial::class.java)
            startActivity(intent)
        }
    }

    fun limpiarDatos(){
        correo2.setText("")
        contra2.setText("")
        telef2.setText("")
    }
}