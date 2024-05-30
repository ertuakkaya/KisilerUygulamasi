package com.example.kisileruygulamasi.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kisileruygulamasi.data.entity.Kisiler

@Dao
interface KisilerDao {
    @Query("SELECT * FROM kisiler")
    suspend fun kisileriYukle() : List<Kisiler>

    // Yeni kisi ekleme
    @Insert
    suspend fun kaydet(kisi: Kisiler)

    // Guncelleme
    @Update
    suspend fun guncelle(kisi : Kisiler)

    // Silme
    @Delete
    suspend fun sil(kisi : Kisiler)

    // Arama
    // icinde arama yapar
    @Query("SELECT * FROM kisiler WHERE kisi_ad like '%' || :aramaKelimesi || '%' ")
    suspend fun ara(aramaKelimesi : String) : List<Kisiler>



}