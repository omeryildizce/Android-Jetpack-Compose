package com.omeryildizce.mvvmkullanimi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SayfaViewModel : ViewModel() {
    var sonuc = MutableLiveData<String>()
    var mRepo = MatematikRepository()
    init {
        sonuc = mRepo.matematikselSonucuGetir()
    }
    fun toplamaYap(alinanSayi1: String = "0", alinanSayi2:String = "0") {
        mRepo.topla(alinanSayi1, alinanSayi2)
    }

    fun carpmaYap(alinanSayi1: String = "0", alinanSayi2:String = "0")  {
        mRepo.carp(alinanSayi1, alinanSayi2)
    }
}