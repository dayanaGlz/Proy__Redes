package com.jdg.proyredes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class IngresoDoc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso_doc)
        var registro: Button = findViewById(R.id.RegDoc)

        registro.setOnClickListener(){
            val intent = Intent(this,registroDoc::class.java)
            startActivity(intent)
        }

        var correo2: EditText = findViewById(R.id.correoIngDoc)
        var contra2: EditText = findViewById(R.id.passIngDoc)
        var usersDBHelper = UsersDBHelper(this)
        var ingreso: Button = findViewById(R.id.ingresoDoc)

        ingreso.setOnClickListener(){
            var correo = correo2.text.toString()
            var contra = contra2.text.toString()
            var comp:Boolean = usersDBHelper.readUser(correo, contra)
            if(comp){
                val intent = Intent(this,pag_inicial::class.java)
                startActivity(intent)
            }
            else {
                //Datos incorrectos
            }
        }
    }
}