package com.omeryildizce.kisileruygulamasi.viewmodel

import androidx.lifecycle.ViewModel
import com.omeryildizce.kisileruygulamasi.repo.KisilerDaoRepository

class KisiDetaySayfaViewModel: ViewModel() {
    var krepo = KisilerDaoRepository()
    fun guncelle(kisiId:Int, kisiAd:String, kisiTel:String){
        krepo.kisiGuncelle(kisiId, kisiAd, kisiTel)
    }
}