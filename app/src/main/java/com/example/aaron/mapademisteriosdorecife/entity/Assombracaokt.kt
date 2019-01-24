package com.example.aaron.mapademisteriosdorecife.entity

import java.util.*

class Assombracaokt {
    var id:Int = 0;
    lateinit  var local:String
    var coordX:Double = 0.0
    var coordY:Double = 0.0
    var nome = ""
    var tempo:Calendar? = null

    constructor(nome:String, id:Int, local:String, coordX:Double, coordY:Double){

        this.nome = nome
        this.id = id
        this.local = local
        this.coordX = coordX
        this.coordY = coordY
    }
}

