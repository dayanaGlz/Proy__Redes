package com.jdg.proyredes

import android.provider.BaseColumns

class DBContract {
    /* Clase interna que define el contenido de la tabla */
    //ya no la necesitamos ya que ya estan las otras 2 tablas de usuarios y doctores
//    class UserEntry : BaseColumns {
//        companion object {
//            val TABLE_NAME = "users"
//            val COLUMN_CORREO = "correo"
//            val COLUMN_CONTRA = "contra"
//            val COLUMN_NOMBRE = "nombre"
//            val COLUMN_TEXT = "texto"
//        }
//    }

    class userPubli: BaseColumns{
        companion object{
            val TABLE_NAME="publicaciones"
            val COLUMN_TITULO="tit"
            val COLUMN_TEMA="tema"
            val COLUMN_CONT="contenido"
            val COLUMN_URLIMG="url"
        }
    }

    //CREAR BASE DE DATOS PARA DOCTOR
    class userDoctor: BaseColumns{
        companion object{
            val TABLE_NAME="doctor"
            val COLUMN_CEDULA="cedula"
            val COLUMN_NOM="nombre"
            val COLUMN_ESPEC="espec"
            val COLUMN_DOMICILIO="domicilio"
            val COLUMN_TELEFONO="tel"
            val COLUMN_EMAIL="email"
            val COLUMN_PASS="pass"
            val COLUMN_DISP="disp"
        }
    }
    //CREAR BD PARA PACIENTE
    class userPaciente: BaseColumns{
        companion object{
            val TABLE_NAME="paciente"
            val COLUMN_ID="id"
            val COLUMN_NOM="nombre"
            val COLUMN_EMAIL="email"
            val COLUMN_PASS="pass"
            val COLUMN_COND="cond"
            val COLUMN_ENFERM="enfermedad"
            val COLUMN_TELEFONO="tel"
            val COLUMN_EDAD="edad"
        }
    }
}