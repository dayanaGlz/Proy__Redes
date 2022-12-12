package com.jdg.proyredes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class perfilPaciente : AppCompatActivity() {

    lateinit var usersDBHelper : UsersDBHelper
    lateinit var id: TextView
    lateinit var nom:EditText
    lateinit var email: EditText
    lateinit var pass : EditText
    lateinit var cond: EditText
    lateinit var enferm: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_paciente)
        usersDBHelper = UsersDBHelper(this)

        //capturamos el nombre de usuario que se nos mando desde el inicio de sesion.
        var user = intent.getStringExtra("usuarioActivo").toString()

        //Leemos los datos del usuario
        var a:ArrayList<String> = usersDBHelper.readUserPac(user)

        id = findViewById(R.id.idPactxt)
        id.setText(a[0])
        nom = findViewById(R.id.nomPactxt)
        nom.setText(a[1])
        email = findViewById(R.id.emailDoctxt)
        email.setText(a[2])
        pass = findViewById(R.id.passDoctxt)
        pass.setText(a[3])
        cond = findViewById(R.id.condPactxt)
        cond.setText(a[4])
        enferm = findViewById(R.id.enfPactxt)
        enferm.setText(a[5])

        //sacar datos del text view
        var id2 = id.text.toString()
        var nom2 = nom.text.toString()
        var email2 = email.text.toString()
        var pass2 = pass.text.toString()
        var cond2 = cond.text.toString()
        var enferm2 = enferm.text.toString()
        //Boton para actualizar datos
        var btnAct: Button = findViewById(R.id.btnConfirmPac)
        btnAct.setOnClickListener(){
            usersDBHelper.updateUserPac(id2, nom2, email2, pass2, cond2, enferm2)
        }

        //boton para regresar al inicio
        var btnIni: Button = findViewById(R.id.btnInicioPac)
        btnIni.setOnClickListener(){
            val intent = Intent(this,pag_inicial::class.java).apply {
                putExtra("usuarioActivo", user)
            }
            startActivity(intent)
        }
    }
}