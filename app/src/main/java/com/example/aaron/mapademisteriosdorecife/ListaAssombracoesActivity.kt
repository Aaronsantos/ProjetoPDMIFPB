package com.example.aaron.mapademisteriosdorecife

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.example.aaron.mapademisteriosdorecife.entity.Assombracao
import com.example.aaron.mapademisteriosdorecife.util.AssombracaoAdapter

class ListaAssombracoesActivity : AppCompatActivity() {


    private lateinit var lista: ListView
    private lateinit var assombracoes: ArrayList<Assombracao>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_assombracoes)


        Log.e("DEBUG", "Entrou Activity")
        this.lista = findViewById(R.id.LVAssombracoes)

        this.lista.adapter = AssombracaoAdapter(this)
    }
}
