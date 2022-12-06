package com.jdg.proyredes

import android.content.Context
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.ArrayList

class AdapterMensajes: RecyclerView.Adapter<HolderMensaje> {

    lateinit var listMensaje:ArrayList<Mensaje>;
    var c:Context;

    constructor(c:Context) : super() {
        this.c = c
    }

    fun addMensaje(m:Mensaje){
        listMensaje.add(m)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HolderMensaje {
        var v:View = LayoutInflater.from(c).inflate(R.layout.card_view_mensajes, parent , false)
        return HolderMensaje(v)
    }

    override fun onBindViewHolder(holder: HolderMensaje, position: Int) {
        holder.getNombre().setText(listMensaje.get(position).getNombre())
    }

    override fun getItemCount(): Int {
        return listMensaje.size
    }
}