package com.jdg.proyredes

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class HolderMensaje(itemView:View) : RecyclerView.ViewHolder(itemView) {
    private var nombre:TextView = itemView.findViewById(R.id.nombreMensaje);
    private var mensaje:TextView = itemView.findViewById(R.id.mensajeMensaje);
    private var hora:TextView = itemView.findViewById(R.id.horaMensaje) ;
    private var fotoMensaje:CircleImageView = itemView.findViewById(R.id.fotoPerfilMensaje);

    fun getNombre(): TextView {
        return nombre
    }
}