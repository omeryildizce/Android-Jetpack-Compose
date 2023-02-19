package com.omeryildizce.collections

class Personel(var no:Int, var isim:String, var adres:Adres) {
    override fun toString(): String {
        return "Personel no=$no, isim=$isim, adres=${adres.il+'/'+adres.ilce}"
    }
}