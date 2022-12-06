package com.jdg.proyredes

class Mensaje {
    var mensaje:String;
    var nombre:String;
    var fotoPerfil:String;
    var type_mensaje:String;
    var hora:String;

    constructor(mensaje:String, nombre:String, fotoPerfil:String, type_mensaje:String, hora: String) {
        this.hora = hora
        this.mensaje = mensaje
        this.nombre = nombre
        this.fotoPerfil = fotoPerfil
        this.type_mensaje = type_mensaje
    }

    constructor(){
        this.hora = ""
        this.mensaje = ""
        this.nombre = ""
        this.fotoPerfil = ""
        this.type_mensaje = ""
    }

    @JvmName("getNombre1")
    fun getNombre(): String{
        return this.nombre
    }

}