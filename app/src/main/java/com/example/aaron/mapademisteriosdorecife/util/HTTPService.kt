package com.example.aaron.mapademisteriosdorecife.util

import com.example.aaron.mapademisteriosdorecife.entity.Assombracao
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HTTPService {

    constructor() {
        retrofit = retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    lateinit var retrofit: Retrofit
    private val  BASE_URL: String = "https://aaronsantos.github.io/MisteriosRecifeData/"


    fun assombracaoService() : AssombracaoService {
        return retrofit.create(AssombracaoService::class.java)

    }
}