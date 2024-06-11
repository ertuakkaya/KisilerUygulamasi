package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kisileruygulamasi.data.entitiy.Kisiler
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// firestore'daln gelen veriyi collectionReference ile alir
class KisilerDataSource (var collectioKisiler: CollectionReference){


    /*

    Firebase'de verikleri yuklememize gerek yoktur.
    Ancak bunun icin metotlar List yerine MutableLiveData<List<Kisiler>> donmelidir.
     */


    // firebase ile verileri yuklemek icin
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    fun kisileriYukle() : MutableLiveData<List<Kisiler>> {


        // firestore'dan gelen her bir kayıt listeye eklenir.
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
        // firestore'dan gelen her bir kayıt listeye eklenir.
        collectioKisiler.addSnapshotListener { value, error ->
            if(value != null){
                val liste = ArrayList<Kisiler>()

                for (d in value.documents ){
                    val kisi = d.toObject(Kisiler::class.java) // firebase'den gelen veriyi Kisiler class'ina cevir
                    if (kisi != null){
                        if(kisi.kisi_ad!!.contains(aramaKelimesi.lowercase())){
                            kisi.kisi_id = d.id // firebase id'sini al
                            liste.add(kisi) // listeye ekle
                        }

                    }
                }
                kisilerListesi.value = liste // listeyi MutableLiveData'ye ata

            }
        }
        return kisilerListesi // MutableLiveData'yi dondur
    }


    fun Kaydet(kisi_Ad: String, kisi_Tel: String) {
        // id'yi bos birak
        val yeniKisi = Kisiler("", kisi_Ad, kisi_Tel)
        // ekle
        collectioKisiler.document().set(yeniKisi)
    }

    // firestore update metodu bir map istiyor. Bu map'i olusturup guncelleme islemi yapilir.
    fun Guncelle(kisi_id : String ,kisi_ad: String, kisi_tel: String) {
        val guncellenenKisi = HashMap<String,Any>()
        guncellenenKisi["kisi_ad"] = kisi_ad
        guncellenenKisi["kisi_tel"] = kisi_tel
        collectioKisiler.document(kisi_id).update(guncellenenKisi)
    }

    // id'yi firestore'a gonder ve sil
    fun Sil(kisi_id : String){
       collectioKisiler.document(kisi_id).delete()

    }





}