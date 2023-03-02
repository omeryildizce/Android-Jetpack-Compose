package com.omeryildizce.kisileruygulamasi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omeryildizce.kisileruygulamasi.entity.Kisiler
import com.omeryildizce.kisileruygulamasi.repo.KisilerDaoRepository

class AnasayfaViewModel : ViewModel() {
    var krepo = KisilerDaoRepository()
    var kisilerListesi = MutableLiveData<List<Kisiler>>()
    init {
        kisileriYukle()
        kisilerListesi = krepo.kisileriGetir()
    }

    fun kisileriYukle(){
        krepo.tumKisileriAl()
    }
    fun ara(aramaKelimesi:String){
        krepo.kisiAra(aramaKelimesi)
    }
    fun sil(kisiId:Int){
        krepo.kisiSilme(kisiId)
    }
}