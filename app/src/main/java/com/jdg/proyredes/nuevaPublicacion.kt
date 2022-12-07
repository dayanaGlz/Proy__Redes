package com.jdg.proyredes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.EditText

class nuevaPublicacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_publicacion)

        var titulo:EditText = findViewById(R.id.editTextTextTitulo)
        var tema:EditText = findViewById(R.id.editTextTextTema)
        var desc:EditText = findViewById(R.id.editTextTextDesc)
        var url:EditText = findViewById(R.id.editTextTextURL)

        var titulo2 = titulo.text.toString()
        var tema2 = tema.text.toString()
        var desc2 = desc.text.toString()
        var url2 = url.text.toString()

        var btn:Button = findViewById(R.id.btnPub)

        btn.setOnClickListener(){
            val intent = Intent(this,pag_inicial::class.java).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE,titulo2)
                putExtra(AlarmClock.EXTRA_MESSAGE,tema2)
                putExtra(AlarmClock.EXTRA_MESSAGE,desc2)
                putExtra(AlarmClock.EXTRA_MESSAGE,url2)
            }
            startActivity(intent)
        }


    }
}