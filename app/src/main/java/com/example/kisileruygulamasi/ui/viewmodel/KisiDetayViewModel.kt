package com.example.kisileruygulamasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisiDetayViewModel : ViewModel() {

    var kisilerRepo = KisilerRepository()

    // Repository sınıfındaki Guncelle fonksiyonunu çağırıyoruz.
    fun Guncelle(kisi_id : Int ,kisi_ad: String, kisi_tel: String) {
       CoroutineScope(Dispatchers.Main).launch {
            kisilerRepo.Guncelle(kisi_id, kisi_ad, kisi_tel)
       }
    }

}