package com.omeryildizce.yemekleruygulamasi.repo

import androidx.lifecycle.MutableLiveData
import com.omeryildizce.yemekleruygulamasi.entity.Yemekler
import com.omeryildizce.yemekleruygulamasi.entity.YemeklerCevap
import com.omeryildizce.yemekleruygulamasi.retrofit.ApiUtils
import com.omeryildizce.yemekleruygulamasi.retrofit.YemeklerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YemeklerDaoRepository {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()
    var yemeklerDaoInterface: YemeklerDaoInterface

    init {
        yemeklerDaoInterface = ApiUtils.getYemeklerDaoInterface()
        yemeklerListesi = MutableLiveData()
    }

    fun yemekleriGetir(): MutableLiveData<List<Yemekler>> {
        return yemeklerListesi
    }

    fun tumYemekleriAl() {
        yemeklerDaoInterface.tumYemekler().enqueue(object : Callback<YemeklerCevap> {
            override fun onResponse(call: Call<YemeklerCevap>, response: Response<YemeklerCevap>) {

                    yemeklerListesi.value = response.body()?.yemekler

            }

            override fun onFailure(call: Call<YemeklerCevap>, t: Throwable) {
            }
        })
    }
}