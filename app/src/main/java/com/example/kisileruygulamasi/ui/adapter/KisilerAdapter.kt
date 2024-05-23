package com.example.kisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entitiy.Kisiler
import com.example.kisileruygulamasi.databinding.CardTasarimBinding
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi.ui.fragment.AnasayfaFragmentDirections
import com.example.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.google.android.material.snackbar.Snackbar

// it is an adapter class that is used to display the data of the people in the application.
// card's data is displayed in the recyclerview.

class KisilerAdapter(var mContext : Context , var kisilerListesi: List<Kisiler> , var viewModel : AnasayfaViewModel)
    : RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {


    inner class CardTasarimTutucu(var tasarim : CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)


    //  CardTasarimBinding baglama islemi
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KisilerAdapter.CardTasarimTutucu {
        val binding : CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_tasarim ,parent, false)
        return CardTasarimTutucu(binding)
    }


    // asil islerin yapildigi yer !!!!
    override fun onBindViewHolder(holder: KisilerAdapter.CardTasarimTutucu, position: Int ) {
        val kisi = kisilerListesi.get(position)
        val t = holder.tasarim

        t.kisiNesnesi = kisi

        // bir card'a tiklandiginda calisacak fonksiyon
        t.carViewSatir.setOnClickListener(){
            // Anasayfa'dan KisiDetayFragment'e gecis yapilacak
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi)
            Navigation.findNavController(it).navigate(gecis) // Gecis yapilacak
        }

        t.imageViewSil.setOnClickListener(){
            Snackbar.make(it, "${kisi.kisi_ad} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                    viewModel.Sil(kisi.kisi_id) // ViewModel'den Sil fonksiyonunu cagiriyoruz
                }.show()
        }
    }


    // kac adet veri gosterilecek
    override fun getItemCount(): Int {
        return kisilerListesi.size // Listenin size'i kadar veri gosterilecek
     }



}







