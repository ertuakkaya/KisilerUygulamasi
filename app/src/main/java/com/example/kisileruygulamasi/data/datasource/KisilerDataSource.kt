package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kisileruygulamasi.data.entitiy.Kisiler
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource (var collectioKisiler: CollectionReference){


    /*

    Firebase'de verikleri yuklememize gerek yoktur.
    Ancak bunun icin metotlar List yerine MutableLiveData<List<Kisiler>> donmelidir.
     */


    // firebase ile verileri yuklemek icin
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    fun kisileriYukle() : MutableLiveData<List<Kisiler>> {

        collectioKisiler.addSnapshotListener { value, error ->
            if(value != null){
                val liste = ArrayList<Kisiler>()

                for (d in value.documents ){
                    val kisi = d.toObject(Kisiler::class.java) // firebase'den gelen veriyi Kisiler class'ina cevir
                    if (kisi != null){
                        kisi.kisi_id = d.id // firebase id'sini al
                        liste.add(kisi) // listeye ekle
                    }
                }
                kisilerListesi.value = liste // listeyi MutableLiveData'ye ata

            }
        }
        return kisilerListesi // MutableLiveData'yi dondur
    }

    fun Ara(aramaKelimesi : String): MutableLiveData<List<Kisiler>> {
        return MutableLiveData<List<Kisiler>>() // bos liste
    }


    fun Kaydet(kisi_Ad: String, kisi_Tel: String) {
        // id'yi bos birak
        val yeniKisi = Kisiler("", kisi_Ad, kisi_Tel)
        // ekle
        collectioKisiler.document().set(yeniKisi)
    }

    fun Guncelle(kisi_id : String ,kisi_ad: String, kisi_tel: String) {
        Log.e("Kisi Guncelle : ", " $kisi_id | $kisi_ad |  $kisi_tel")
    }

    fun Sil(kisi_id : String){
        Log.e("Kisi Silindi", kisi_id.toString())
    }





}