package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.databinding.FragmentKisiDetayBinding
import com.example.kisileruygulamasi.ui.viewmodel.KisiDetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiDetayFragment : Fragment() {

    private lateinit var binding: FragmentKisiDetayBinding

    private lateinit var viewModel : KisiDetayViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // viewBinding işlemi
        //binding = FragmentKisiDetayBinding.inflate(inflater, container, false)

        // dataBinding işlemi
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_kisi_detay, container, false)

        // XML dosyasındaki verileri bu sınıfa bağlıyoruz
        binding.kisiDetayFragment = this

        // toolbar başlığını değiştirme
        binding.kisiDetayToolbarBaslik = "Kişi Detay"





        // Detay sayfasına gelen veriyi almak için bir bundle oluşturuyoruz
        val bundle: KisiDetayFragmentArgs by navArgs()

        // bundle içerisindeki veriyi almak için gelenKisi adında bir değişken oluşturuyoruz
        val gelenKisi = bundle.kisi


        // gelenKisi değişkenini XML dosyasına göndermek için tanımlıyoruz
        binding.kisiNesnesi = gelenKisi


        ///////// VİEW BİNDİNG İLE YAPILAN İŞLEMLER
        /*
        // gelenKisi değişkeni içerisindeki verileri ilgili alanlara set ediyoruz
        binding.editTextKisiAd.setText(gelenKisi.kisi_ad)
        binding.editTextKisiTel.setText(gelenKisi.kisi_tel)


        // not worked
        binding.buttonGuncelle.setOnClickListener {
            val kisi_ad = binding.editTextKisiAd.text.toString()
            val kisi_tel = binding.editTextKisiTel.text.toString()
            buttonGuncelle(gelenKisi.kisi_id, kisi_ad, kisi_tel)
        }
        */


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // viewModel tanımlaması
        val tempViewModel : KisiDetayViewModel by viewModels()
        viewModel = tempViewModel
    }

    // ViewModel içerisindeki Guncelle fonksiyonunu çağırıyoruz.
    fun buttonGuncelle(kisi_id : Int ,kisi_ad: String, kisi_tel: String) {
        viewModel.Guncelle(kisi_id, kisi_ad, kisi_tel)
    }


}