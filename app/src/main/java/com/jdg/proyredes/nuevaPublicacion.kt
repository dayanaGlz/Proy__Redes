package com.jdg.proyredes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class nuevaPublicacion : AppCompatActivity() {

    lateinit var usersDBHelper : UsersDBHelper

    private lateinit var titulo2:EditText
    private lateinit var tema2:EditText
    private lateinit var desc2:EditText
    private lateinit var url2:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_publicacion)

        titulo2 = findViewById(R.id.editTextTextTitulo)
        tema2 = findViewById(R.id.editTextTextTema)
        desc2 = findViewById(R.id.editTextTextDesc)
        url2 = findViewById(R.id.editTextTextURL)

        var titulo = titulo2.text.toString()
        var tema = tema2.text.toString()
        var desc = desc2.text.toString()
        var url = url2.text.toString()

        var btn:Button = findViewById(R.id.btnPub)

        btn.setOnClickListener(){
            addNew(titulo, tema, desc, url)
            val intent = Intent(this,pag_inicial::class.java)
            startActivity(intent)
        }
    }

    fun addNew(titulo2:String, tema2:String, desc2:String, url2:String){

        var result = usersDBHelper.add_New(UMPublic(tit=titulo2,tema = tema2,cont = desc2,img = url2))
        //clear all edittext s
        limpiarDatos()

        if(result){
            Toast.makeText(this,"Publicacion Exitosa", Toast.LENGTH_LONG).show()
            val intent = Intent(this,pag_inicial::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this,"Fallo en el registro", Toast.LENGTH_LONG).show()
        }
    }
    fun limpiarDatos(){
        titulo2.setText("")
        tema2.setText("")
        desc2.setText("")
        url2.setText("")
    }
}