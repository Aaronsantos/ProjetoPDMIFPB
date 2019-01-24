package com.example.aaron.mapademisteriosdorecife.util

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class BancoHelper(context: Context):
        SQLiteOpenHelper(context, "mapamisterios.db", null, 6){

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table if not exists assombracao(" +
                "id integer primary key," +
                " tempo timestamp," +
                "nome string, localcurto string, descricao string, lat double, lng double)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.wtf("DEBUG", "ATUALIZANDO BANCO")
        db!!.execSQL("DROP TABLE IF EXISTS assombracao");
        onCreate(db);
    }
}