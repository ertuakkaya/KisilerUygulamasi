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
    fun Sil(kisi_id : Int){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepo.Sil(kisi_id)
            kisileriYukle() // Silme işleminden sonra tekrar listeyi yüklüyoruz.
        }
    }

    fun kisileriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                // VİewModel'den veri göndermek için MutableLiveData'nın .value özelliğini kullanıyoruz.
                kisilerListesi.value = kisilerRepo.kisileriYukle() // gelen veriyi kisilerListesi'ne atıyoruz.
            }
            catch (e : Exception){

            }
        }
    }
    fun Ara(aramaKelimesi : String){
        CoroutineScope(Dispatchers.Main).launch {
           try {
               kisilerListesi.value = kisilerRepo.Ara(aramaKelimesi)
           }catch(e : Exception){

           }


        }
    }


}