package com.jdg.proyredes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class registroDoc : AppCompatActivity() {
    lateinit var usersDBHelper : UsersDBHelper

    private lateinit var correo2: EditText
    private lateinit var contra2: EditText
    private lateinit var telef2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_doc)
        correo2 = findViewById(R.id.correoIngDoc)
        contra2 = findViewById(R.id.passIngDoc)
        telef2 = findViewById(R.id.telefonoDoc)

        usersDBHelper = UsersDBHelper(this)

        var but: Button = findViewById(R.id.RegDocomp)

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