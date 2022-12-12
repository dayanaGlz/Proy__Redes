package com.jdg.proyredes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class perfilDoc : AppCompatActivity() {

    lateinit var usersDBHelper : UsersDBHelper
    lateinit var cedula: EditText
    lateinit var nom: EditText
    lateinit var espec : EditText
    lateinit var domicilio: EditText
    lateinit var tel: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_doc)
        usersDBHelper = UsersDBHelper(this)

        //capturamos el nombre de usuario que se nos mando desde el inicio de sesion.
        var user = intent.getStringExtra("usuarioActivo").toString()

        //Leemos los datos del usuario
        var a:ArrayList<String> = usersDBHelper.readUserDoc(user)

        //Escribir los datos del usuario en la base de datos
        cedula = findViewById(R.id.cedtxt)
        cedula.setText(a[0])
        nom = findViewById(R.id.nomDoctxt)
        nom.setText(a[1])
        espec = findViewById(R.id.especDoctxt)
        espec.setText(a[2])
        domicilio = findViewById(R.id.domicDoctxt)
        domicilio.setText(a[3])
        tel = findViewById(R.id.telDoctxt)
        tel.setText(a[4])

        //sacar datos del text view
        var cedula2 = cedula.text.toString()
        var nom2 = nom.text.toString()
        var espec2 = espec.text.toString()
        var domicilio2 = domicilio.text.toString()
        var tel2 = tel.text.toString()
        //Boton para actualizar datos
        var btnAct: Button = findViewById(R.id.btnConfirmDoc)
        btnAct.setOnClickListener(){
            usersDBHelper.updateUserDoc(cedula2, nom2, espec2, domicilio2, tel2)
        }

        //boton para regresar al inicio
        var btnIni: Button = findViewById(R.id.btnInicioDoc)
        btnIni.setOnClickListener(){
            val intent = Intent(this,pag_inicial::class.java).apply {
                putExtra("usuarioActivo", user)
            }
            startActivity(intent)
        }
    }
}