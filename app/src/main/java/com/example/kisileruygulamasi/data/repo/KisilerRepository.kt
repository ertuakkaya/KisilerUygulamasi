package com.example.kisileruygulamasi.data.repo

import android.util.Log
import com.example.kisileruygulamasi.data.datasource.KisilerDataSource
import com.example.kisileruygulamasi.data.entitiy.Kisiler

class KisilerRepository (var kisilerDataSource : KisilerDataSource) {

    //var kisilerDataSource = KisilerDataSource()


    // Data Source sınıfındaki Kaydet fonksiyonunu çağırıyoruz.
    suspend fun Kaydet(kisi_Ad: String, kisi_Tel: String){
        kisilerDataSource.Kaydet(kisi_Ad, kisi_Tel)
    }

    // Data Source sınıfındaki Guncelle fonksiyonunu çağırıyoruz.
    suspend fun Guncelle(kisi_id : Int ,kisi_ad: String, kisi_tel: String) {
        kisilerDataSource.Guncelle(kisi_id, kisi_ad, kisi_tel)
    }

    // Data Source sınıfındaki Sil fonksiyonunu çağırıyoruz.
    suspend fun Sil(kisi_id : Int){
        kisilerDataSource.Sil(kisi_id)
    }

    // Data Source sınıfındaki kisileriYukle fonksiyonunu çağırıyoruz.
    suspend fun kisileriYukle() : List<Kisiler> = kisilerDataSource.kisileriYukle()

    suspend fun Ara(aramaKelimesi : String): List<Kisiler> = kisilerDataSource.Ara(aramaKelimesi)
}