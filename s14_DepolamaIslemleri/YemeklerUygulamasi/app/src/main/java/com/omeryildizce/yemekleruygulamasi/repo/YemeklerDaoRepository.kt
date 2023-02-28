package com.omeryildizce.yemekleruygulamasi.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.omeryildizce.yemekleruygulamasi.entity.Yemekler
import com.omeryildizce.yemekleruygulamasi.room.VeriTabani
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class YemeklerDaoRepository(var application: Application) {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()
    var vt:VeriTabani
    init {
        vt = VeriTabani.veritabaniErisim(application)!!
        yemeklerListesi = MutableLiveData()

    }

    fun yemekleriGetir(): MutableLiveData<List<Yemekler>>{
        return yemeklerListesi
    }

    fun tumYemekleriAl() {
        val job:Job = CoroutineScope(Dispatchers.Main).launch{
            yemeklerListesi.value = vt.yemeklerDao().tumYemekler()
        }
    }
}