package com.jdg.proyredes

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

import java.util.ArrayList

class UsersDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,
    null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // En caso de actualizar la version de BD elimina lo anterior, para iniciar otra
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    @Throws(SQLiteConstraintException::class)
    fun insertUser(user: UserModel): Boolean {
        //Obtenemos la base de datos para escribir
        val db = writableDatabase
        // Creamos un ContentValues, para asignar los valores a insertar
        val values = ContentValues()
        values.put(DBContract.UserEntry.COLUMN_CORREO, user.correo)
        values.put(DBContract.UserEntry.COLUMN_CONTRA, user.contra)
        values.put(DBContract.UserEntry.COLUMN_CEDU, user.ced)

        //Insertamos el nuevo registro
        val newRowId = db.insert(DBContract.UserEntry.TABLE_NAME, null, values)

        return true
    }

    @Throws(SQLiteConstraintException::class)
    fun deleteUser(userid: String): Boolean {
        //Obtenemos la base de datos para escribir
        val db = writableDatabase
        // Creamos el query para buscar llave a eliminar
        val selection = DBContract.UserEntry.COLUMN_CORREO + " LIKE ?"
        val selectionArgs = arrayOf(userid)
        // Eliminamos el registro
        db.delete(DBContract.UserEntry.TABLE_NAME, selection, selectionArgs)

        return true
    }

    @Throws(SQLiteConstraintException::class)
    fun updateUser(correo: String, contra: String, telef:String): Boolean {
        //Obtenemos la base de datos para escribir
        val db = writableDatabase
        // Creamos el query para buscar llave a modificar
        val registro = ContentValues()
        registro.put("contra", contra)
        registro.put("telef", telef)

        // Modificamos el registro
        db.update(DBContract.UserEntry.TABLE_NAME, registro,
            "correo=${correo}",null)

        return true
    }

    @SuppressLint("Range")
    fun readUser(cedula: String, contra: String): Boolean {
        val users = ArrayList<UserModel>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("select * from " + DBContract.UserEntry.TABLE_NAME
                    + " WHERE " + DBContract.UserEntry.COLUMN_CEDU + "='"
                    + cedula + "'"
                    + " AND " + DBContract.UserEntry.COLUMN_CONTRA + "='"
                    + contra + "'", null)
        } catch (e: SQLiteException) {
            // si la BBD no esta creada, la creamos
            db.execSQL(SQL_CREATE_ENTRIES)
            return false
        }

        var contra: String
        var cedu: String
        var nom: String
        var corr: String
        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                corr = cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_CORREO))
                contra = cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_CONTRA))
                nom = cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_NAME))
                cedu = cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_CEDU))

                users.add(UserModel(corr, contra, nom, cedu))
                cursor.moveToNext()
            }
        }
        return true
    }

    @SuppressLint("Range")
    fun readAllUsers(): ArrayList<UserModel> {
        val users = ArrayList<UserModel>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("select * from " + DBContract.UserEntry.TABLE_NAME, null)
        } catch (e: SQLiteException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }

        var correo: String
        var contra: String
        var nom: String
        var cedu: String
        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                correo = cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_CORREO))
                contra = cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_CONTRA))
                nom = cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_NAME))
                cedu = cursor.getString(cursor.getColumnIndex(DBContract.UserEntry.COLUMN_CEDU))

                users.add(UserModel(correo, contra, nom,cedu))
                cursor.moveToNext()
            }
        }
        return users
    }

    companion object {
        // En caso de modificar la estructura de la BD, incrementar la version en 1.
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "FeedReader.db"

        private val SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DBContract.UserEntry.TABLE_NAME + " (" +
                    DBContract.UserEntry.COLUMN_CORREO + " TEXT PRIMARY KEY," +
                    DBContract.UserEntry.COLUMN_CONTRA + " TEXT," +
                    DBContract.UserEntry.COLUMN_TELEF + " TEXT)"

        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DBContract.UserEntry.TABLE_NAME
    }

}