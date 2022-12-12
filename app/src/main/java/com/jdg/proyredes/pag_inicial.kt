package com.jdg.proyredes

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList

class pag_inicial : AppCompatActivity(){

    lateinit var usersDBHelper : UsersDBHelper
    private lateinit var showAll: LinearLayout
    private lateinit var contenedor: LinearLayout
    private lateinit var aBuscar: EditText
    lateinit var user:String

    init {
        showAllNews(this.contenedor)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pag_inicial)

        usersDBHelper = UsersDBHelper(this)
        showAll = findViewById(R.id.showPublicaciones)
        contenedor = findViewById(R.id.contenedorNews)
        aBuscar= findViewById(R.id.txtBuscar)

        //capturamos el nombre de usuario que se nos mando desde el inicio de sesion.
        user= intent.getStringExtra("usuarioActivo").toString()

        var btnMenu:Button = findViewById(R.id.btnMenu)

        btnMenu.setOnClickListener(){
            val intent = Intent(this,Menu::class.java).apply {
                putExtra("usuarioActivo", user)
            }
            startActivity(intent)
        }

        showAllNews(contenedor)

        var btnBuscar:Button = findViewById(R.id.btnMenu)

        btnBuscar.setOnClickListener(){
            busqueda(contenedor)
        }

    }

    fun showAllNews(v: View){
        var news = usersDBHelper.readNews()
        showAll.removeAllViews()

        news.forEach {
            var one_new= LinearLayout(this)
            var img = ImageView(this)
            //img.sourceLayoutResId
            //it.id.toString() + " --- " +
            one_new.addView(img)

            //agregamos un textview con el titulo de la publicacion
            var tit_new= TextView(this)
            tit_new.textSize=12f
            tit_new.text = it.tit.toString()
            one_new.addView(tit_new)

            var tema_new= TextView(this)
            tema_new.textSize=9f
            tema_new.text = it.tema.toString()
            one_new.addView(tema_new)

            var cont_new= TextView(this)
            cont_new.textSize=10f
            cont_new.text = it.tit.toString()
            one_new.addView(cont_new)

            //lo agregamos al linear general que mostrara_todo
            showAll.addView(one_new)
        }

    }

    fun busqueda(v:View){
        var palabra=aBuscar.text.toString()
        var encontrado: ArrayList<UMPublic>

        if(palabra.length!=0) {
            encontrado = usersDBHelper.read_new(palabra)

            encontrado.forEach {
                var one_new= LinearLayout(this)
                var img = ImageView(this)
                //img.sourceLayoutResId
                //it.id.toString() + " --- " +
                one_new.addView(img)

                //agregamos un textview con el titulo de la publicacion
                var tit_new= TextView(this)
                tit_new.textSize=12f
                tit_new.text = it.tit.toString()
                one_new.addView(tit_new)

                var tema_new= TextView(this)
                tema_new.textSize=9f
                tema_new.text = it.tema.toString()
                one_new.addView(tema_new)

                var cont_new= TextView(this)
                cont_new.textSize=10f
                cont_new.text = it.tit.toString()
                one_new.addView(cont_new)

                //lo agregamos al linear general que mostrara_todo
                showAll.addView(one_new)
            }
        }
        else
            Toast.makeText(this, "Ingrese una palabra", Toast.LENGTH_LONG).show()

    }
}