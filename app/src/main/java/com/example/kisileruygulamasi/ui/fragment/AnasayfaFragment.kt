package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entitiy.Kisiler
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi.ui.adapter.KisilerAdapter
import com.example.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasi.util.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {


    private lateinit var binding: FragmentAnasayfaBinding

    // viewModel setup
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // viewModel tanımlaması
        viewModel = viewModels<AnasayfaViewModel>().value
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {



        // Data Binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false)

        // XML dosyasinda tanimlanan degiskenlere erismek icin
        binding.anasayfaFragment = this


        // Data Binding ile toolbar basligi degistirme
        binding.anasayfaToolbarBaslik = "KİSİLER"

        viewModel.kisilerListesi.observe(viewLifecycleOwner){

            val kisilerAdapter = KisilerAdapter(requireContext(),it, viewModel) // Adapter bilgileri duzenler
            binding.kisilerAdapter = kisilerAdapter // Recyclerview goruntuler
        }

        binding.searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.Ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.Ara(query)
                return true
            }
        })


        return binding.root
    }

    // it icin bir view nesnesi alir ve bu nesne uzerinden Navigation islemi yapar
    fun fabTikla(it : View){
        Navigation.gecisYap(it, R.id.kisiKayitGecis)
    }

    fun Ara(aramaKelimesi : String){
        viewModel.Ara(aramaKelimesi)
    }


}