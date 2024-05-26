package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.databinding.FragmentKisiKayitBinding
import com.example.kisileruygulamasi.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiKayitFragment : Fragment() {


    private lateinit var binding: FragmentKisiKayitBinding

    // viewModel setup
    private lateinit var viewModel: KisiKayitViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // ViewBinding kullanımı
        //binding = FragmentKisiKayitBinding.inflate(inflater, container, false)


       // Data binding kullanımı
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_kisi_kayit, container, false)

        // Data binding ile fragment içindeki değişkenlere erişim (XML dosyasındaki değişkenlere erişim)
        binding.kisiKayitFragment = this



        // Toolbar title değiştirme
        binding.toolbarKisiKayit.title = "Kişi Kayıt"


        binding.buttonKaydet.setOnClickListener {
            val kisi_Ad = binding.editTextKisiAd.text.toString()
            val kisi_Tel = binding.editTextKisiTel.text.toString()



            buttonKaydet(kisi_Ad, kisi_Tel)
        }





        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewModel tanımlaması
        val tempViewModel: KisiKayitViewModel by viewModels()

        viewModel = tempViewModel

    }

    fun buttonKaydet(kisi_Ad: String, kisi_Tel: String) {
        // ViewModel içerisindeki Kaydet fonksiyonunu çağırıyoruz.
        viewModel.Kaydet(kisi_Ad, kisi_Tel)
    }


}