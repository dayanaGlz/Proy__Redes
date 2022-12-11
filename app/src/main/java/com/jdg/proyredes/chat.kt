package com.jdg.proyredes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
//import de.hdodenhof.circleimageview.CircleImageView

class chat : AppCompatActivity() {

    //lateinit private var fotoPerfil:CircleImageView ;
    lateinit private var nombre: TextView;
    //lateinit private var rvMensajes: RecyclerView;
    lateinit private var txtMensaje: EditText;
    lateinit private var btnEnviar: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        //fotoPerfil = findViewById(R.id.fotoPerfil)
        nombre = findViewById(R.id.nombre)
        //rvMensajes = findViewById(R.id.rvMensajes)
        txtMensaje = findViewById(R.id.txtMensaje)
        btnEnviar = findViewById(R.id.btnEnviar)
    }
}