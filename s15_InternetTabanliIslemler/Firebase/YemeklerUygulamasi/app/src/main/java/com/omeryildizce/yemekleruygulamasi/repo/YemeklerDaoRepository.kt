package com.omeryildizce.yemekleruygulamasi.repo

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*
import com.omeryildizce.yemekleruygulamasi.entity.Yemekler

class YemeklerDaoRepository {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()
    var refYemekler:DatabaseReference

    init {
        val db = FirebaseDatabase.getInstance()
        refYemekler = db.getReference("yemekler")
        yemeklerListesi = MutableLiveData()
    }

    fun yemekleriGetir():MutableLiveData<List<Yemekler>> {
        return yemeklerListesi
    }

    fun tumYemekleriAl(){
        refYemekler.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val liste = ArrayList<Yemekler>()

                for(d in snapshot.children){
                    val yemek = d.getValue(Yemekler::class.java)

                    if (yemek != null){
                        yemek.yemek_id = d.key
                        liste.add(yemek)
                    }
                }

                yemeklerListesi.value = liste
            }
            override fun onCancelled(error: DatabaseError) {}
        })
    }
}