package com.omeryildizce.retrofitkullanimi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.omeryildizce.retrofitkullanimi.ui.theme.RetrofitKullanimiTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitKullanimiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Sayfa()
                }
            }
        }
    }
}

@Composable
fun Sayfa() {
    LaunchedEffect(key1 = true) {
        //sil(0)
        // ekle("Bahadır", "054585478547")
        // guncelle(10 , "Bahar", "054585478547")

        tumKisiler()
        // arama("dn")
    }

}

fun tumKisiler() {
    val kisilerDaoInterface = ApiUtils.getKisilerDaoInterface()
    kisilerDaoInterface.tumKisiler().enqueue(object : Callback<KisilerCevap> {
        override fun onResponse(call: Call<KisilerCevap>, response: Response<KisilerCevap>) {
            val liste = response.body()!!.kisiler
            for (kisi in liste) {
                Log.e("Kişi Bilgisi: ", "*************")
                Log.e("Kişi Id:  ", "${kisi.kisi_id}")
                Log.e("Kişi Ad:  ", kisi.kisi_ad)
                Log.e("Kişi Tel: ", kisi.kisi_tel)
            }
        }

        override fun onFailure(call: Call<KisilerCevap>, t: Throwable) {


        }
    })
}

fun arama(kisi_ad: String) {
    val kisilerDaoInterface = ApiUtils.getKisilerDaoInterface()
    kisilerDaoInterface.kisiAra(kisi_ad).enqueue(object : Callback<KisilerCevap> {
        override fun onResponse(call: Call<KisilerCevap>, response: Response<KisilerCevap>) {
            val liste = response.body()!!.kisiler
            for (kisi in liste) {
                Log.e("Kişi Bilgisi: ", "*************")
                Log.e("Kişi Id:  ", "${kisi.kisi_id}")
                Log.e("Kişi Ad:  ", kisi.kisi_ad)
                Log.e("Kişi Tel: ", kisi.kisi_tel)
            }
        }

        override fun onFailure(call: Call<KisilerCevap>, t: Throwable) {
            TODO("Not yet implemented")
        }
    })
}

fun sil(kisi_id: Int) {
    val kisilerDaoInterface = ApiUtils.getKisilerDaoInterface()
    kisilerDaoInterface.kisiSil(kisi_id).enqueue(object : Callback<CRUDCevap> {
        override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
            val message = response.body()!!.message
            val success = response.body()!!.success
            Log.e("Kişi Sil", "Başarı: $success - Mesaj: $message")
        }

        override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {
            TODO("Not yet implemented")
        }
    })
}

fun ekle(kisi_ad: String, kisi_tel: String) {
    val kisilerDaoInterface = ApiUtils.getKisilerDaoInterface()
    kisilerDaoInterface.kisiEkle(kisi_ad, kisi_tel).enqueue(object : Callback<CRUDCevap> {
        override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
            val message = response.body()!!.message
            val success = response.body()!!.success
            Log.e("Kişi Eklendi", "Başarı: $success - Mesaj: $message")

        }

        override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {
            TODO("Not yet implemented")
        }
    })
}

fun guncelle(kisi_id: Int, kisi_ad: String, kisi_tel: String) {
    val kisilerDaoInterface = ApiUtils.getKisilerDaoInterface()
    kisilerDaoInterface.kisiGuncelle(kisi_id, kisi_ad, kisi_tel)
        .enqueue(object : Callback<CRUDCevap> {
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {
                val message = response.body()!!.message
                val success = response.body()!!.success
                Log.e("Kişi Güncellendi", "Başarı: $success - Mesaj: $message")

            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RetrofitKullanimiTheme {
        Sayfa()
    }
}