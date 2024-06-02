package com.example.kisileruygulamasi.retrofit

import com.example.kisileruygulamasi.data.entitiy.CRUDCevap
import com.example.kisileruygulamasi.data.entitiy.KisilerCevap
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface KisilerDao {

    // kasimadalan.pe.hu/api/kisiler/tum_kisiler.php
    // kasimadalan.pe.hu/ -> Base URL
    // kisiler/tum_kisiler.php -> webservis url

    @GET("kisiler/tum_kisiler.php")
    suspend fun kisileriYukle() : KisilerCevap


    // Field'ların web servise bire bir ayni olmasi gerekir
    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded // turkce destegi
    suspend fun kaydet(@Field("kisi_ad")kisi_ad : String,
                       @Field("kisi_tel") kisi_tel : String) : CRUDCevap

    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    suspend fun guncelle(@Field("kisi_id") kisi_id : Int,
                         @Field("kisi_ad") kisi_ad : String,
                         @Field("kisi_tel") kisi_tel : String) : CRUDCevap

    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    suspend fun sil(@Field("kisi_id") kisi_id : Int) : CRUDCevap

    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    suspend fun ara(@Field("kisi_ad") aramaKelimesi : String) : KisilerCevap

}