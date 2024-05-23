package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import com.example.kisileruygulamasi.data.entitiy.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource {


    suspend fun kisileriYukle() : List<Kisiler> =

      withContext(Dispatchers.IO){
          val kisilerListesi = ArrayList<Kisiler>()
          kisilerListesi.add(Kisiler(1,"Rana","5555555555"))
          kisilerListesi.add(Kisiler(2,"Nagehan","57575757"))
          kisilerListesi.add(Kisiler(3,"Muhammed","45454545"))
          kisilerListesi.add(Kisiler(4,"Ertugrul","788787878"))
          return@withContext kisilerListesi
      }


    suspend fun Kaydet(kisi_Ad: String, kisi_Tel: String) {
        Log.e("Kişi Adı & Kisi Tel : ", "$kisi_Ad |  $kisi_Tel")
    }

    suspend fun Guncelle(kisi_id : Int ,kisi_ad: String, kisi_tel: String) {
        Log.e("Kisi Guncelle : ", " $kisi_id | $kisi_ad |  $kisi_tel")
    }

    suspend fun Sil(kisi_id : Int){
        Log.e("Kisi Silindi", kisi_id.toString())
    }

    suspend fun Ara(aramaKelimesi : String): List<Kisiler> =

        withContext(Dispatchers.IO){
            val kisilerListesi = ArrayList<Kisiler>()
            kisilerListesi.add(Kisiler(1,"Rana","5555555555"))
            return@withContext kisilerListesi
        }


}