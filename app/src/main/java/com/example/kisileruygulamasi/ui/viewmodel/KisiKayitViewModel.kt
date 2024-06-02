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
class KisiKayitViewModel @Inject constructor(var kisilerRepo : KisilerRepository) : ViewModel() {




    // Repository sınıfındaki Kaydet fonksiyonunu çağırıyoruz.
    // CoroutineScope ile Dispatchers.Main kullanıyoruz.
    // launch ile işlemi başlatıyoruz.

    // Viewmodelde kullanici arayuzu ile iletisim saglandigi icin CoroutineScope ve Dispatchers.Main kullanilmistir.
    fun Kaydet(kisi_Ad: String, kisi_Tel: String){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                kisilerRepo.Kaydet(kisi_Ad, kisi_Tel)
            }catch (e : Exception){
                Log.e("kaydet hata", e.toString())
            }
        }



    }
}