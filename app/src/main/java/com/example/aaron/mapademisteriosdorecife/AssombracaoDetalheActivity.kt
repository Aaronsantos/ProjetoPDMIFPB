package com.example.aaron.mapademisteriosdorecife

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.aaron.mapademisteriosdorecife.entity.Assombracao
import com.example.aaron.mapademisteriosdorecife.entity.AssombracaoDAO
import java.util.*
import android.content.Intent
import android.net.Uri


class AssombracaoDetalheActivity : AppCompatActivity() {

    lateinit var nome: TextView
    lateinit var local: TextView
    lateinit var epoca: TextView
    lateinit var desc: TextView
    lateinit var voltarBtn: Button
    lateinit var encontreiBtn: Button
    lateinit var verMapaBtn: Button

    lateinit var dao : AssombracaoDAO

    lateinit var assombracao: Assombracao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assombracao_detalhe)

        this.assombracao = intent.getSerializableExtra("ASSOMBRACAO") as Assombracao
        this.dao = AssombracaoDAO(this)

        this.nome = findViewById(R.id.tvNomeDetalhe)
        this.local = findViewById(R.id.tvLocalDetalhe)
        this.desc = findViewById(R.id.tvDescDetalhe)
        this.encontreiBtn = findViewById(R.id.btnEncontreiDetalhe)
        this.verMapaBtn = findViewById(R.id.btnVerNoMapa)
        this.epoca = findViewById(R.id.tvEpocaDetalhe)

        this.encontreiBtn.setOnClickListener({marcarVisitado(it)})
        this.verMapaBtn.setOnClickListener({this.abrirMap(it)})

        if(dao.assombracaoExist(this.assombracao.id)){
            this.encontreiBtn.setEnabled(false)
        }

        this.nome.text = assombracao.nome
        this.local.text = assombracao.local
        this.epoca.text = assombracao.epoca
        this.desc.text = assombracao.descricao
    }

    fun marcarVisitado(view: View) {

        dao.add(this.assombracao)
        this.encontreiBtn.setEnabled(false)
    }

    fun abrirMap(view: View) {
        val gmmIntentUri = Uri.parse("google.navigation:q=${assombracao.coords.lat},${assombracao.coords.lng}")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
       mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }
}

