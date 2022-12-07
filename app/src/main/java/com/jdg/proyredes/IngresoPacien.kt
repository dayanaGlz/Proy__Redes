package com.jdg.proyredes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.EditText

class IngresoPacien : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso_pacien)
        var registro:Button = findViewById(R.id.btnRegPac)

        registro.setOnClickListener(){
            val intent = Intent(this,registro_pacien::class.java)
            startActivity(intent)
        }

        var correo2:EditText = findViewById(R.id.correoIngPac)
        var contra2:EditText = findViewById(R.id.passIngPac)
        var usersDBHelper = UsersDBHelper(this)
        var ingreso:Button = findViewById(R.id.btnInPacien)

        ingreso.setOnClickListener(){
            var correo = correo2.text.toString()
            var contra = contra2.text.toString()
            var comp:Boolean = usersDBHelper.readUser(correo, contra)
            if(comp){
                val intent = Intent(this,pag_inicial::class.java).apply {
                    putExtra(EXTRA_MESSAGE,correo)
                }
                startActivity(intent)
            }
            else {
                //Datos incorrectos
            }
        }
    }
}