package com.example.aaron.mapademisteriosdorecife.entity

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.aaron.mapademisteriosdorecife.util.BancoHelper
import java.util.*

class AssombracaoDAO{
    private lateinit var banco: BancoHelper
    private val TABLE = "assombracao"

    constructor(context: Context){

        Log.e("DEBUG", "Construindo dao")
        this.banco = BancoHelper(context)
    }

    // inserir
    fun add(assombracao:Assombracao){

        val cv = ContentValues()
        cv.put("id", assombracao.id)
        cv.put("tempo", Calendar.getInstance().timeInMillis)
        cv.put("nome", assombracao.nome)
        cv.put("localcurto", assombracao.localCurto)
        cv.put("descricao", assombracao.descricao)
        cv.put("lat", assombracao.coords.lat)
        cv.put("lng", assombracao.coords.lng)
        this.banco.writableDatabase.insert(TABLE, null, cv)
    }

    // select
    fun read(): ArrayList<Assombracao>{


        Log.e("DEBUG", "Entrou dao")
        val colunas = arrayOf("id", "nome", "localcurto", "descricao", "lat", "lng", "tempo")
        val lista = ArrayList<Assombracao>()

        val cursor = this.banco.readableDatabase.query(TABLE, colunas, null, null, null, null, null)

        if (cursor.count > 0){
            cursor.moveToFirst()
            do{
                var assombracao = Assombracao()
                assombracao.id = cursor.getInt(cursor.getColumnIndex("id"))
                assombracao.time = Calendar.getInstance()
                assombracao.time.timeInMillis = cursor.getLong(cursor.getColumnIndex("tempo"))
                assombracao.localCurto = cursor.getString(cursor.getColumnIndex("localcurto"))
                assombracao.descricao = cursor.getString(cursor.getColumnIndex("descricao"))
                assombracao.coords = Coords()
                assombracao.coords.lat = cursor.getDouble(cursor.getColumnIndex("lat"))
                assombracao.coords.lng = cursor.getDouble(cursor.getColumnIndex("lng"))
                assombracao.nome = cursor.getString(cursor.getColumnIndex("nome"))


                lista.add(assombracao)
            }while(cursor.moveToNext())
        }

        return lista
    }

    // select com where
    fun read(id: Int): Assombracao?{
        val colunas = arrayOf("id", "tempo")
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        val cursor = this.banco.readableDatabase.query(TABLE, colunas, where, pWhere, null, null, null)

        if (cursor.count > 0){
            cursor.moveToFirst()
            var assombracao = Assombracao()

            assombracao.id = cursor.getInt(cursor.getColumnIndex("id"))
            assombracao.time.timeInMillis = cursor.getLong(cursor.getColumnIndex("tempo"))
            assombracao.localCurto = cursor.getString(cursor.getColumnIndex("localcurto"))
            assombracao.descricao = cursor.getString(cursor.getColumnIndex("descricao"))
            assombracao.coords.lat = cursor.getDouble(cursor.getColumnIndex("lat"))
            assombracao.coords.lng = cursor.getDouble(cursor.getColumnIndex("lng"))
            assombracao.nome = cursor.getString(cursor.getColumnIndex("nome"))

            return assombracao
        }

        return null
    }

    fun assombracaoExist(id:Int): Boolean {

        val colunas = arrayOf("id", "tempo")
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        val cursor = this.banco.readableDatabase.query(TABLE, colunas, where, pWhere, null, null, null)

        if (cursor.count > 0) return true
        else return false

    }

    // atualização
    fun update(assombracao: Assombracao){
        val where = "id = ?"
        val pWhere = arrayOf(assombracao.id.toString())
        val cv = ContentValues()

        cv.put("id", assombracao.id)
        cv.put("tempo", Calendar.getInstance().timeInMillis)
        cv.put("nome", assombracao.nome)
        cv.put("localcurto", assombracao.localCurto)
        cv.put("descricao", assombracao.descricao)
        cv.put("lat", assombracao.coords.lat)
        cv.put("lng", assombracao.coords.lng)

        this.banco.writableDatabase.update(TABLE, cv, where, pWhere)
    }

    // remoção
    fun delete(id: Int){
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        this.banco.writableDatabase.delete(TABLE, where, pWhere)
    }
}
