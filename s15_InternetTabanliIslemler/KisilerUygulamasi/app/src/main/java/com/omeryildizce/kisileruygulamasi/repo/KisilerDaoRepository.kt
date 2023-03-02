package com.omeryildizce.kisileruygulamasi.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.omeryildizce.kisileruygulamasi.entity.CRUDCevap
import com.omeryildizce.kisileruygulamasi.entity.Kisiler
import com.omeryildizce.kisileruygulamasi.entity.KisilerCevap
import com.omeryildizce.kisileruygulamasi.retrofit.ApiUtils
import com.omeryildizce.kisileruygulamasi.retrofit.KisilerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KisilerDaoRepository {
    var kisilerListesi = MutableLiveData<List<Kisiler>>()
    var kisilerDaoInterface: KisilerDaoInterface

    init {
        kisilerDaoInterface = ApiUtils.getKisilerDaoInterface()
        kisilerListesi = MutableLiveData()
    }

    fun kisileriGetir(): MutableLiveData<List<Kisiler>> {
        return kisilerListesi
    }

    fun tumKisileriAl() {
        kisilerDaoInterface.tumKisiler().enqueue(object : Callback<KisilerCevap> {
            override fun onResponse(call: Call<KisilerCevap>, response: Response<KisilerCevap>) {
                val liste = response.body()?.kisiler
                kisilerListesi.value = liste
            }

            override fun onFailure(call: Call<KisilerCevap>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun kisiAra(aramaKelimesi: String) {

        kisilerDaoInterface.kisiAra(aramaKelimesi).enqueue(object : Callback<KisilerCevap> {
            override fun onResponse(call: Call<KisilerCevap>, response: Response<KisilerCevap>) {
                val liste = response.body()?.kisiler
                kisilerListesi.value = liste
            }

            override fun onFailure(call: Call<KisilerCevap>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun kisiKayit(kisiAd: String, kisiTel: String) {
        kisilerDaoInterface.kisiEkle(kisiAd,kisiTel).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {

            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun kisiGuncelle(kisiId: Int, kisiAd: String, kisiTel: String) {
        kisilerDaoInterface.kisiGuncelle(kisiId,kisiAd,kisiTel).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {

            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun kisiSilme(kisiId: Int) {
        kisilerDaoInterface.kisiSil(kisiId).enqueue(object : Callback<CRUDCevap> {
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                tumKisileriAl()
            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}