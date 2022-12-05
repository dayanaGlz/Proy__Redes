package com.jdg.proyredes

import android.provider.BaseColumns

class DBContract {
    /* Clase interna que define el contenido de la tabla */
    class UserEntry : BaseColumns {
        companion object {
            val TABLE_NAME = "users"
            val COLUMN_CORREO = "correo"
            val COLUMN_NAME = "nom"
            val COLUMN_CEDU = "cedula"
            val COLUMN_CONTRA = "contra"
            val COLUMN_TELEF = "telef"
        }
    }
}