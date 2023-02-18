package com.omeryildizce.nesnetabanliprogramlama

class Odev6 {
    fun maasHesapla(gunSayisi: Int) :Int {
        val calismaSaati = gunSayisi * 8
        println("Çalışma saati: $calismaSaati")
        var maas = 0
        if (calismaSaati > 160) {
            val mesaiFazlasi = calismaSaati - 160
            maas = 160 * 10 + mesaiFazlasi * 20
        } else {
            maas = calismaSaati * 10
        }
        return maas
    }
}