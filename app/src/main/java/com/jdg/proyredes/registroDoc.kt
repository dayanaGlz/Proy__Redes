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
    private lateinit var nom2: EditText
    private lateinit var contra2: EditText
    private lateinit var cedula: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_doc)

        correo2 = findViewById(R.id.correoRegDoc)
        nom2 = findViewById(R.id.correoRegDoc)
        contra2 = findViewById(R.id.passRegDoc)
        cedula = findViewById(R.id.ceduRegDoc)

        usersDBHelper = UsersDBHelper(this)

        var but: Button = findViewById(R.id.btnRegistroDoc)

        but.setOnClickListener() {
            var correo = correo2.text.toString()
            var nom = nom2.text.toString()
            var contra = contra2.text.toString()
            var ced = cedula.text.toString()
            usersDBHelper.insertUser(UserModel(correo = correo,contra = contra,nom = nom, ced = ced))

            //clear all edittext
            limpiarDatos()
            val intent = Intent(this,pag_inicial::class.java)
            startActivity(intent)
        }
    }
    fun limpiarDatos(){
        correo2.setText("")
        contra2.setText("")
        nom2.setText("")
        cedula.setText("")
    }
}