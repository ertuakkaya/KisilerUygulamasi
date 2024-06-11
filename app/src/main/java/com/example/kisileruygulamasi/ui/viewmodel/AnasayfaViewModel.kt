package com.example.kisileruygulamasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.entitiy.Kisiler
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var kisilerRepo : KisilerRepository) : ViewModel() {

    //var kisilerRepo = KisilerRepository()

    // Tasarimdan data almak icin MutableLiveData kullanilir.
    var kisilerListesi = MutableLiveData<List<Kisiler>>()
    init {
        kisileriYukle()
    }


    // Repository sınıfındaki Sil fonksiyonunu çağırıyoruz.
    fun Sil(kisi_id : String){
        kisilerRepo.Sil(kisi_id)
        //kisileriYukle() // Silme işleminden sonra tekrar listeyi yüklüyoruz.
    }


    // Artık firebase ile MutableLiveData aldığımız için .value kullanmıyoruz.
    fun kisileriYukle(){
        // VİewModel'den veri göndermek için MutableLiveData'nın .value özelliğini kullanıyoruz.
        kisilerListesi= kisilerRepo.kisileriYukle() // gelen veriyi kisilerListesi'ne atıyoruz.
    }
    fun Ara(aramaKelimesi : String){
        kisilerListesi= kisilerRepo.Ara(aramaKelimesi)
    }


}