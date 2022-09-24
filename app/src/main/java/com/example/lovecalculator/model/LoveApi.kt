package com.example.lovecalculator.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun calculateLove(
        @Query("fname") firstName:String,
        @Query("sname") secondName:String,
        @Header("X-RapidApi-Key") key:String = "63a0d70af1mshaa9f8848c94ee95p13439bjsn9fc173965b94",
        @Header("X-RapidApi-Host") host:String = "love-calculator.p.rapidapi.com"
    ): Call<LoveModel>

}