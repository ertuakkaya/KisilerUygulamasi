package com.example.kisileruygulamasi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class KisiKayitViewModel @Inject constructor(var kisilerRepo : KisilerRepository) : ViewModel() {




    // Repository sınıfındaki Kaydet fonksiyonunu çağırıyoruz.
    // CoroutineScope ile Dispatchers.Main kullanıyoruz.
    // launch ile işlemi başlatıyoruz.

    // Viewmodelde kullanici arayuzu ile iletisim saglandigi icin CoroutineScope ve Dispatchers.Main kullanilmistir.
    fun Kaydet(kisi_Ad: String, kisi_Tel: String){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepo.Kaydet(kisi_Ad, kisi_Tel)
        }



    }
}