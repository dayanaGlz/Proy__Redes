package com.jdg.proyredes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val doctor: Button =findViewById(R.id.btnRegistroDoc)
        val paciente:Button=findViewById(R.id.btnRegDoc)

        doctor.setOnClickListener(){
            val intent = Intent(this,IngresoDoc::class.java)
            startActivity(intent)
        }
        paciente.setOnClickListener(){
            val intent = Intent(this,IngresoPacien::class.java)
            startActivity(intent)
        }

    }
}