package com.omeryildizce.nesnetabanliprogramlama

class Odev4 {
    fun kelimeAdeti(kelime:String, harf:Char){
        var sonuc = 0
        for (k in kelime.lowercase()){
            if (k == harf){
                sonuc++
            }
        }
        println("Harf Adeti: $sonuc")
    }

}