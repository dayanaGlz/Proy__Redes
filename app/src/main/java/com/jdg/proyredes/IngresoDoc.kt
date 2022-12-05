package com.jdg.proyredes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class IngresoDoc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso_doc)
<<<<<<< Updated upstream
=======
        var registro: Button = findViewById(R.id.btnRegDoc)

        registro.setOnClickListener(){
            val intent = Intent(this,registroDoc::class.java)
            startActivity(intent)
        }

        var ced: EditText = findViewById(R.id.cedIngDoc)
        var contra: EditText = findViewById(R.id.passIngDoc)
        var usersDBHelper = UsersDBHelper(this)
        var ingreso: Button = findViewById(R.id.ingresoDoc)

        ingreso.setOnClickListener(){
            var cedu = ced.text.toString()
            var contra = contra.text.toString()
            var comp:Boolean = usersDBHelper.readUser(cedu, contra)
            if(comp){
                val intent = Intent(this,pag_inicial::class.java)
                startActivity(intent)
            }
            else {
                //Datos incorrectos
            }
        }
>>>>>>> Stashed changes
    }
}