package com.omeryildizce.kisileruygulamasi.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*
import com.omeryildizce.kisileruygulamasi.entity.Kisiler

class KisilerDaoRepository {
    var kisilerListesi = MutableLiveData<List<Kisiler>>()
    var refKisiler: DatabaseReference

    init {
        refKisiler = FirebaseDatabase.getInstance().getReference("kisiler")
        kisilerListesi = MutableLiveData()
    }

    fun kisileriGetir(): MutableLiveData<List<Kisiler>> {
        return kisilerListesi
    }

    fun tumKisileriAl() {
        refKisiler.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val liste = ArrayList<Kisiler>()
                for (d in snapshot.children) {
                    val kisi = d.getValue(Kisiler::class.java)
                    if (kisi != null) {
                        kisi.kisi_id = d.key
                        liste.add(kisi)
                    }
                }
                kisilerListesi.value = liste
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }

    fun kisiAra(aramaKelimesi: String) {

        refKisiler.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val liste = ArrayList<Kisiler>()
                for (d in snapshot.children) {
                    val kisi = d.getValue(Kisiler::class.java)
                    if (kisi != null) {
                        if (kisi.kisi_ad!!.lowercase().contains(aramaKelimesi.lowercase())){

                        kisi.kisi_id = d.key
                        liste.add(kisi)
                        }
                    }
                }
                kisilerListesi.value = liste
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }

    fun kisiKayit(kisiAd: String, kisiTel: String) {
        val yeniKisi = Kisiler("", kisiAd, kisiTel)
        refKisiler.push().setValue(yeniKisi)
    }

    fun kisiGuncelle(kisiId: String, kisiAd: String, kisiTel: String) {
        val bilgiler = HashMap<String, Any>()
        bilgiler["kisi_ad"] = kisiAd
        bilgiler["kisi_tel"] = kisiTel
        refKisiler.child(kisiId).updateChildren(bilgiler)
    }

    fun kisiSilme(kisiId: String) {
        refKisiler.child(kisiId).removeValue()
    }
}