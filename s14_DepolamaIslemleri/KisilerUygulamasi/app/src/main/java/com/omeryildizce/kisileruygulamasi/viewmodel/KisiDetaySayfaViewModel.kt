package com.omeryildizce.kisileruygulamasi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.omeryildizce.kisileruygulamasi.repo.KisilerDaoRepository

class KisiDetaySayfaViewModel(application: Application) : AndroidViewModel(application) {
    var krepo = KisilerDaoRepository(application)
    fun guncelle(kisiId:Int, kisiAd:String, kisiTel:String){
        krepo.kisiGuncelle(kisiId, kisiAd, kisiTel)
    }
}