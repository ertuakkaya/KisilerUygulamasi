package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import com.example.kisileruygulamasi.data.entitiy.Kisiler
import com.example.kisileruygulamasi.retrofit.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource (var kisilerDao : KisilerDao){


//    suspend fun kisileriYukle() : List<Kisiler> =
//
//      withContext(Dispatchers.IO){
//
//          return@withContext kisilerDao.kisileriYukle().kisiler
//
//      }
    suspend fun kisileriYukle() : List<Kisiler> =
    withContext(Dispatchers.IO){
        val kisiler = kisilerDao.kisileriYukle().kisiler
        Log.d("KisilerDataSource","$kisiler")
        return@withContext kisiler
    }


    // KisilerDao'daki kaydet fonksiyonunu cagiriyoruz.
    suspend fun Kaydet(kisi_ad: String, kisi_tel: String) {
        kisilerDao.kaydet(kisi_ad, kisi_tel)
    }

    suspend fun Guncelle(kisi_id : Int ,kisi_ad: String, kisi_tel: String) {
       kisilerDao.guncelle(kisi_id, kisi_ad, kisi_tel)
    }

    suspend fun Sil(kisi_id : Int){
        kisilerDao.sil(kisi_id)
    }

    suspend fun Ara(aramaKelimesi : String): List<Kisiler> =

        withContext(Dispatchers.IO){

            return@withContext kisilerDao.ara(aramaKelimesi).kisiler
        }


}