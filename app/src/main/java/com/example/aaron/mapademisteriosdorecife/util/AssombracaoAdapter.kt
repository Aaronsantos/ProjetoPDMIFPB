package com.example.aaron.mapademisteriosdorecife.util

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.aaron.mapademisteriosdorecife.entity.Assombracao
import com.example.aaron.mapademisteriosdorecife.entity.AssombracaoDAO
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.widget.CalendarView
import android.widget.TextView
import com.example.aaron.mapademisteriosdorecife.R
import java.util.*

class AssombracaoAdapter(var context: Context): BaseAdapter(){
    private lateinit var dao: AssombracaoDAO
    private lateinit var lista: ArrayList<Assombracao>

    init {

        Log.e("DEBUG", "Entrou Init")
        this.dao = AssombracaoDAO(context)
        this.lista = this.dao.read()
    }

    override fun getCount(): Int {
        return this.lista.size
    }

    override fun getItem(position: Int): Any {
        return this.lista[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val assombracao = this.lista[position]
        val layout: View

        if (convertView == null){
            layout = View.inflate(context, R.layout.assombracao_layout, null)
        }else{
            layout = convertView
        }

        val tvNome = layout.findViewById<TextView>(R.id.tvAssombracaoNome)
        val tvData = layout.findViewById<TextView>(R.id.tvAssombracaoData)
        val tvLocal = layout.findViewById<TextView>(R.id.tvAssombracaoLocal)

        tvNome.text = assombracao.nome
        tvData.text = "${assombracao.time.get(Calendar.DAY_OF_MONTH)}/${assombracao.time.get(Calendar.MONTH) + 1}/${assombracao.time.get(Calendar.YEAR)}"
        tvLocal.text = assombracao.localCurto

        return layout
    }
}
