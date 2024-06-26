package com.android.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper

class AdminSQLite (context: Context, name: String, factory: CursorFactory?, version: Int)
    : SQLiteOpenHelper(context,name,factory,version)
{
    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL(

            "create table productos" +
            "(secuencial INTEGER primary key autoincrement,"
                    +"codigo_principal TEXT,"
                    +"descripcion TEXT,"
                    +"precio REAL,"
                    +"estado TEXT )"

        )

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}