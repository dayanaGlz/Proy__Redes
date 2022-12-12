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
    private lateinit var nombre2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_doc)
        correo2 = findViewById(R.id.correoRegDoc)
        contra2 = findViewById(R.id.passRegDoc)
        nombre2 = findViewById(R.id.NomRegDoc)

        usersDBHelper = UsersDBHelper(this)

        var but: Button = findViewById(R.id.btnRegistroDoc)

        but.setOnClickListener() {
            var correo = correo2.text.toString()
            var contra = contra2.text.toString()
            var nombre = nombre2.text.toString()
            usersDBHelper.insertUserDoctor(UserModel(correo = correo,contra = contra,nombre = nombre, texto = ""))
            //clear all edittext s
            limpiarDatos()
            val intent = Intent(this,IngresoDoc::class.java)
            startActivity(intent)
        }
    }
    fun limpiarDatos(){
        correo2.setText("")
        contra2.setText("")
        nombre2.setText("")
    }
}