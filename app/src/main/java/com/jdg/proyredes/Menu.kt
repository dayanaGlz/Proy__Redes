package com.jdg.proyredes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Menu : AppCompatActivity() {

    lateinit var user:String
    lateinit var usersDBHelper : UsersDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        //Tomamos el nombre del usurio registrado desde el inicio de sesion y lo escribimos en el TextView
        user= intent.getStringExtra("usuarioActivo").toString()
        var usuario: TextView = findViewById(R.id.NomPerfil)
        usuario.setText("user")

        //boton de ver perfil mandado el nombre para identificar cual usuario
        var perfil:Button = findViewById(R.id.btnVerPerf)
        perfil.setOnClickListener(){
            //Identificar si es doctor o paciente para mostrar diferente tipo de perfil
            usersDBHelper = UsersDBHelper(this)
            var a:ArrayList<String> = usersDBHelper.readUserPac(user)
            if(a != null){
                //Es paciente
                val intent = Intent(this,perfilPaciente::class.java).apply {
                    putExtra("usuarioActivo", user)
                }
            }else{
                //Es doctor
                val intent = Intent(this,perfilDoc::class.java).apply {
                    putExtra("usuarioActivo", user)
                }
            }

            val intent = Intent(this,pag_inicial::class.java).apply {
                putExtra("usuarioActivo", user)
            }
            startActivity(intent)
        }

        //Boton de cerrar sesion solo manda a la pantalla de inicio
        var cerrar:Button = findViewById(R.id.btnSalir)
        cerrar.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        //Boton salir regresa a la pagina inicial sigue mandado cual es el nombre del usuario activo
        var salir: FloatingActionButton = findViewById(R.id.floatingActionButton2)
        salir.setOnClickListener(){
            val intent = Intent(this,pag_inicial::class.java).apply {
                putExtra("usuarioActivo", user)
            }
            startActivity(intent)
        }
    }
}