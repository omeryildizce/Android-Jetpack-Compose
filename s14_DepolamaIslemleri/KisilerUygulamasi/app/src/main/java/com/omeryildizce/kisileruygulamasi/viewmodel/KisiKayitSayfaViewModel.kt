package com.omeryildizce.kisileruygulamasi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.omeryildizce.kisileruygulamasi.repo.KisilerDaoRepository

class KisiKayitSayfaViewModel(application: Application) : AndroidViewModel(application) {
    var krepo = KisilerDaoRepository(application)
    fun kayit(kisiAd:String, kisiTel:String){
        krepo.kisiKayit(kisiAd, kisiTel)
    }
}