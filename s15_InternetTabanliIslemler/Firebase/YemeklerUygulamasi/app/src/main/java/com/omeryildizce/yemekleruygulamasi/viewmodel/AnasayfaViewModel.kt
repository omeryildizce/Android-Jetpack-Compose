package com.omeryildizce.yemekleruygulamasi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omeryildizce.yemekleruygulamasi.entity.Yemekler
import com.omeryildizce.yemekleruygulamasi.repo.YemeklerDaoRepository

class AnasayfaViewModel : ViewModel() {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()
    var yrepo = YemeklerDaoRepository()

    init {
        yemekleriYukle()
        yemeklerListesi = yrepo.yemekleriGetir()
    }

    fun yemekleriYukle(){
        yrepo.tumYemekleriAl()
    }
}