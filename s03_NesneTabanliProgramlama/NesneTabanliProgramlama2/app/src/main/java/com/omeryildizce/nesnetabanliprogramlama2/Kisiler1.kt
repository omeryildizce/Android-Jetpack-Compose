package com.omeryildizce.nesnetabanliprogramlama2

class Kisiler1(var ad:String, var yas: Int, var adres: Adres) {

    override fun toString(): String {
        return "Kisiler1(ad='$ad', yas=$yas, adres=${adres.il+'/' +adres.ilce})"
    }
}