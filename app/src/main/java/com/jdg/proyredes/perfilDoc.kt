package com.jdg.proyredes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class perfilDoc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_doc)

        val btnHome:Button= findViewById(R.id.btnConfirm)

        btnHome.setOnClickListener(){
            val intent = Intent(this,consulta::class.java)
            startActivity(intent)
        }
    }
}