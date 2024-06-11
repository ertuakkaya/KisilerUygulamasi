package com.example.kisileruygulamasi.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kisileruygulamasi.data.datasource.KisilerDataSource
import com.example.kisileruygulamasi.data.entitiy.Kisiler

class KisilerRepository (var kisilerDataSource : KisilerDataSource) {

    //var kisilerDataSource = KisilerDataSource()


    // Data Source sınıfındaki Kaydet fonksiyonunu çağırıyoruz.
    fun Kaydet(kisi_Ad: String, kisi_Tel: String){
        kisilerDataSource.Kaydet(kisi_Ad, kisi_Tel)
    }

    // Data Source sınıfındaki Guncelle fonksiyonunu çağırıyoruz.
    fun Guncelle(kisi_id : String ,kisi_ad: String, kisi_tel: String) {
        kisilerDataSource.Guncelle(kisi_id, kisi_ad, kisi_tel)
    }

    // Data Source sınıfındaki Sil fonksiyonunu çağırıyoruz.
    fun Sil(kisi_id : String){
        kisilerDataSource.Sil(kisi_id)
    }

    // Data Source sınıfındaki kisileriYukle fonksiyonunu çağırıyoruz.
    fun kisileriYukle() : MutableLiveData<List<Kisiler>> = kisilerDataSource.kisileriYukle()

    fun Ara(aramaKelimesi : String): MutableLiveData<List<Kisiler>> = kisilerDataSource.Ara(aramaKelimesi)
}