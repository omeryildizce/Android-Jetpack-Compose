package com.omeryildizce.firebaseveritabani

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.omeryildizce.firebaseveritabani.ui.theme.FirebaseVeritabaniTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirebaseVeritabaniTheme {
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
    // ekle()
    // sil
    // guncelle()
    //tumKisiler()
   // esitlik()
   // degerAraligi()
    limit()
}

fun ekle() {
    val db = FirebaseDatabase.getInstance()
    val refKisiler = db.getReference("kisiler")
    val yeniKisi = Kisiler("Talat", 25)
    refKisiler.push().setValue(yeniKisi)
}

fun tumKisiler() {
    val db = FirebaseDatabase.getInstance()
    val refKisiler = db.getReference("kisiler")

    refKisiler.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            for (d in snapshot.children) {
                val kisi = d.getValue(Kisiler::class.java)
                if (kisi != null) {
                    Log.e("Kisi", "***********")
                    Log.e("Kisi", d.key.toString())
                    Log.e("Kisi", kisi.kisi_ad.toString())
                    Log.e("Kisi", kisi.kisi_yas.toString())
                }
            }
        }

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }
    })
}

fun sil() {
    val db = FirebaseDatabase.getInstance()
    val refKisiler = db.getReference()

    refKisiler.child("-NPSdD1ksXaM--DBF6DU").removeValue()
}

fun guncelle() {
    val db = FirebaseDatabase.getInstance()
    val refKisiler = db.getReference("kisiler")
    val bilgiler = HashMap<String, Any>()
    bilgiler["kisi_ad"] = "Halit"
    bilgiler["kisi_yas"] = 25
    refKisiler.child("-NPSdD1ksXaM--DBF6DU").updateChildren(bilgiler)
}


fun esitlik() {
    val db = FirebaseDatabase.getInstance()
    val refKisiler = db.getReference("kisiler")
    val sorgu = refKisiler.orderByChild("kisi_ad").equalTo("Talat")
    sorgu.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            for (d in snapshot.children) {
                val kisi = d.getValue(Kisiler::class.java)
                if (kisi != null) {
                    Log.e("Kisi", "***********")
                    Log.e("Kisi", d.key.toString())
                    Log.e("Kisi", kisi.kisi_ad.toString())
                    Log.e("Kisi", kisi.kisi_yas.toString())
                }
            }
        }

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }
    })
}
fun degerAraligi() {
    val db = FirebaseDatabase.getInstance()
    val refKisiler = db.getReference("kisiler")
    val sorgu = refKisiler.orderByChild("kisi_yas").startAt(20.0).endAt(40.0)
    sorgu.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            for (d in snapshot.children) {
                val kisi = d.getValue(Kisiler::class.java)
                if (kisi != null) {
                    Log.e("Kisi", "***********")
                    Log.e("Kisi", d.key.toString())
                    Log.e("Kisi", kisi.kisi_ad.toString())
                    Log.e("Kisi", kisi.kisi_yas.toString())
                }
            }
        }

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }
    })
}
fun limit() {
    val db = FirebaseDatabase.getInstance()
    val refKisiler = db.getReference("kisiler")
    val sorgu = refKisiler.limitToFirst(1)
    sorgu.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            for (d in snapshot.children) {
                val kisi = d.getValue(Kisiler::class.java)
                if (kisi != null) {
                    Log.e("Kisi", "***********")
                    Log.e("Kisi", d.key.toString())
                    Log.e("Kisi", kisi.kisi_ad.toString())
                    Log.e("Kisi", kisi.kisi_yas.toString())
                }
            }
        }

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }
    })
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirebaseVeritabaniTheme {
        Sayfa()
    }
}