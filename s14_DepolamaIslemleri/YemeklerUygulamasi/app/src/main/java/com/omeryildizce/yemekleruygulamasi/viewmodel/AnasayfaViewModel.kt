package com.omeryildizce.yemekleruygulamasi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omeryildizce.yemekleruygulamasi.entity.Yemekler
import com.omeryildizce.yemekleruygulamasi.repo.YemeklerDaoRepository

class AnasayfaViewModel(application: Application): AndroidViewModel(application){
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()
    var yrepo = YemeklerDaoRepository(application)
    init {
        yemekleriYukle()
        yemeklerListesi = yrepo.yemekleriGetir()
    }
    fun yemekleriYukle(){
        yrepo.tumYemekleriAl()
    }
}