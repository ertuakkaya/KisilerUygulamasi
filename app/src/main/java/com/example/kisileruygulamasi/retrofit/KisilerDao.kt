package com.example.kisileruygulamasi.retrofit

import com.example.kisileruygulamasi.data.entitiy.KisilerCevap
import retrofit2.http.GET

interface KisilerDao {

    // kasimadalan.pe.hu/api/kisiler/tum_kisiler.php
    // kasimadalan.pe.hu/ -> Base URL
    // kisiler/tum_kisiler.php -> webservis url

    @GET("kisiler/tum_kisiler.php")
    suspend fun kisileriYukle() : KisilerCevap

}