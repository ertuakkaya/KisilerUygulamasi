package com.example.kisileruygulamasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiDetayViewModel @Inject constructor(var kisilerRepo : KisilerRepository) : ViewModel() {



    // Repository sınıfındaki Guncelle fonksiyonunu çağırıyoruz.
    fun Guncelle(kisi_id : Int ,kisi_ad: String, kisi_tel: String) {
       CoroutineScope(Dispatchers.Main).launch {
            kisilerRepo.Guncelle(kisi_id, kisi_ad, kisi_tel)
       }
    }

}