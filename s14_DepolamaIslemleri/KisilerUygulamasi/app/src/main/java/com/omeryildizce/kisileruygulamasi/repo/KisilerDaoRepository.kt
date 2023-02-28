package com.omeryildizce.kisileruygulamasi.repo

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.omeryildizce.kisileruygulamasi.entity.Kisiler
import com.omeryildizce.kisileruygulamasi.room.Veritabani
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class KisilerDaoRepository(var application: Application) {
    var kisilerListesi = MutableLiveData<List<Kisiler>>()
    var vt: Veritabani

    init {
        vt = Veritabani.veritabaniErisim(application)!!
        kisilerListesi = MutableLiveData()

    }

    fun kisileriGetir(): MutableLiveData<List<Kisiler>> {
        return kisilerListesi
    }

    fun tumKisileriAl() {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = vt.kisilerDao().tumKisiler()
        }
    }

    fun kisiAra(aramaKelimesi: String) {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = vt.kisilerDao().kisiArama(aramaKelimesi)
        }
    }

    fun kisiKayit(kisiAd: String, kisiTel: String) {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            val kisi = Kisiler(0, kisiAd, kisiTel)
            vt.kisilerDao().kisiEkle(kisi)
        }
    }

    fun kisiGuncelle(kisiId: Int, kisiAd: String, kisiTel: String) {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            val kisi = Kisiler(kisiId, kisiAd, kisiTel)
            vt.kisilerDao().kisiGuncelle(kisi)
        }
    }

    fun kisiSilme(kisiId: Int) {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            val kisi = Kisiler(kisiId, "","")
            vt.kisilerDao().kisiSil(kisi)
            tumKisileriAl()
        }
    }
}