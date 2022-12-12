package com.jdg.proyredes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.ArrayList


class IngresoDoc : AppCompatActivity() {

    lateinit var usersDBHelper : UsersDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso_doc)

        usersDBHelper = UsersDBHelper(this)
        var registro: Button = findViewById(R.id.btnRegDoc)

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
            var doctorActivo = usersDBHelper.readUserDocLogin(correo, contra)


            if(doctorActivo!=null){
                val intent = Intent(this,pag_inicial::class.java).apply {
                    putExtra("usuarioActivo",doctorActivo[0].nombre)
                }
                startActivity(intent)
            }
            else {
                //Datos incorrectos
                Toast.makeText(this, "Fallo en el ingreso.Intente de nuevo", Toast.LENGTH_LONG).show()
            }
        }
    }
}