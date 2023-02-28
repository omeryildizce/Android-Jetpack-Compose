package com.omeryildizce.roomkullanimi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.omeryildizce.roomkullanimi.ui.theme.RoomKullanimiTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomKullanimiTheme {
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
    val  context = LocalContext.current
    val vt = Veritabani.veritabaniErisim(context)
    LaunchedEffect(key1 = true){
        if (vt != null) {
          //  ekle(vt)
            tumKisiler(vt)
        }
    }
}
fun tumKisiler(vt:Veritabani){
    val job:Job = CoroutineScope(Dispatchers.Main).launch {
        val liste = vt.kisilerDao().tumKisiler()
        for (k in liste ){
            Log.e( "Kişi: ", "**********" )
            Log.e("Kişi Id", "${k.kisi_id}")
            Log.e("Kişi Ad", "${k.kisi_adi}")
            Log.e("Kişi Telefon", "${k.kisi_tel}")
        }
    }
}
fun ekle(vt: Veritabani){
    val job : Job = CoroutineScope(Dispatchers.Main).launch {
        val yeniKisi = Kisiler(0, "Mehmet", "3333")
        vt.kisilerDao().kisiEkle(yeniKisi)
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RoomKullanimiTheme {
        Sayfa()
    }
}