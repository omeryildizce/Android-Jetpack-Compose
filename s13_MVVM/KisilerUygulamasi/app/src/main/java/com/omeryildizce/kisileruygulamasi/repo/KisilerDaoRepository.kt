package com.omeryildizce.kisileruygulamasi.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.omeryildizce.kisileruygulamasi.entity.Kisiler

class KisilerDaoRepository {
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        kisilerListesi = MutableLiveData()
    }
    fun kisileriGetir():MutableLiveData<List<Kisiler>>{
        return kisilerListesi
    }
    fun tumKisileriAl() {
        val liste = mutableListOf<Kisiler>()
        val k1 = Kisiler(1, "Ahmet", "0541111111")
        val k2 = Kisiler(2, "Ömer", "0541111111")
        liste.add(k1)
        liste.add(k2)

        kisilerListesi.value = liste
    }

    fun kisiAra(aramaKelimesi:String){

        Log.e("Arama", "kisiAra: $aramaKelimesi")
    }
    fun kisiKayit(kisiAd:String, kisiTel:String){
        Log.e("Kişi Kayıt", "$kisiAd - $kisiTel" )
    }
    fun kisiGuncelle(kisiId: Int,kisiAd:String, kisiTel:String){
        Log.e("Kişi Güncelle", "$kisiId:  $kisiAd - $kisiTel" )
    }
    fun kisiSilme(kisiId: Int ){
        Log.e("Kişi Sil", "$kisiId" )
    }
}