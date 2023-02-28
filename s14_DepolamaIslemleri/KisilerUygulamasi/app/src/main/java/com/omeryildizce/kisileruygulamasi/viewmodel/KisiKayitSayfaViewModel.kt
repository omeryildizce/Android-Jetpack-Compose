package com.omeryildizce.kisileruygulamasi.viewmodel

import androidx.lifecycle.ViewModel
import com.omeryildizce.kisileruygulamasi.repo.KisilerDaoRepository

class KisiKayitSayfaViewModel: ViewModel() {
    var krepo = KisilerDaoRepository()
    fun kayit(kisiAd:String, kisiTel:String){
        krepo.kisiKayit(kisiAd, kisiTel)
    }
}