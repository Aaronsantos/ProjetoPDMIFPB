package com.example.aaron.mapademisteriosdorecife.util

import com.example.aaron.mapademisteriosdorecife.entity.Assombracao
import retrofit2.Call
import retrofit2.http.GET

interface  AssombracaoService {

    /**
     * HEADER MANIPULATION
     * Set static headers for a method using the @Headers annotation.
     */
    @GET("assombracoes.json")
    fun list(): Call<List<Assombracao>>

}