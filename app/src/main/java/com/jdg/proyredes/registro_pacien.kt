package com.jdg.proyredes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class registro_pacien : AppCompatActivity() {
    lateinit var usersDBHelper : UsersDBHelper

    private lateinit var correo2: EditText
    private lateinit var contra2: EditText
    private lateinit var nombre2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_pacien)
        correo2 = findViewById(R.id.correoReg)
        contra2 = findViewById(R.id.passReg)
        nombre2 = findViewById(R.id.nameReg)

        usersDBHelper = UsersDBHelper(this)

        var but: Button = findViewById(R.id.btnRegistroPac)

        but.setOnClickListener() {
            var correo = correo2.text.toString()
            var contra = contra2.text.toString()
            var nombre = nombre2.text.toString()
            usersDBHelper.insertUserPaciente(UserModel(correo = correo,contra = contra,nombre = nombre, texto = ""))
            //clear all edittext s
            limpiarDatos()
            val intent = Intent(this,IngresoPacien::class.java)
            startActivity(intent)
        }
    }
    fun limpiarDatos(){
        correo2.setText("")
        contra2.setText("")
        nombre2.setText("")
    }

}