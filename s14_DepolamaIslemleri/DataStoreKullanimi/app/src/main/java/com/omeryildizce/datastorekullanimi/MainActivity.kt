package com.omeryildizce.datastorekullanimi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.omeryildizce.datastorekullanimi.ui.theme.DataStoreKullanimiTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DataStoreKullanimiTheme {
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
    val context = LocalContext.current
    val ads = AppDataStore(context)

    LaunchedEffect(key1 = true) {
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            // Kayıt
            ads.kayitAd("Ömer")
            ads.kayitYas(23)
            ads.kayitBoy(1.95)
            ads.kayitBekarMi(true)
            val liste = HashSet<String>()
            liste.add("Mehmet")
            liste.add("Ali")
            liste.add("Fatma")
            liste.add("Betül")
            ads.kayitArkadasListe(liste)

            // Okuma
            val gelenAd = ads.okuAd()
            val gelenYas = ads.okuYas()
            val gelenBoy = ads.okuBoy()
            val gelenBekarMi = ads.okuBekarMi()
            val gelenKayitArkadasListe = ads.okuArkadasListe()

            Log.e("Bilgi", "Ad: $gelenAd")
            Log.e("Bilgi", "Yas: $gelenYas")
            Log.e("Bilgi", "Boy: $gelenBoy")
            Log.e("Bilgi", "Bekar mı?: $gelenBekarMi")
            Log.e("Bilgi", "Arkadaş Sayıs: ${gelenKayitArkadasListe.size}")
            for ((index, arkadas) in gelenKayitArkadasListe.withIndex()) {
                Log.e("Bilgi", "${index + 1}. $arkadas")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DataStoreKullanimiTheme {
        Sayfa()
    }
}