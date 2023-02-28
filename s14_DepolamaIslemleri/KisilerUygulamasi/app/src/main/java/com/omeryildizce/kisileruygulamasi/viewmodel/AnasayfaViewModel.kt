package com.omeryildizce.kisileruygulamasi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omeryildizce.kisileruygulamasi.entity.Kisiler
import com.omeryildizce.kisileruygulamasi.repo.KisilerDaoRepository

class AnasayfaViewModel(application: Application) : AndroidViewModel(application) {
    var krepo = KisilerDaoRepository(application)
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