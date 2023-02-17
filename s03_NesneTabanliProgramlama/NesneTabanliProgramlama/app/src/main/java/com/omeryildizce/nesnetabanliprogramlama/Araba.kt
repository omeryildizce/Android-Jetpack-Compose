package com.omeryildizce.nesnetabanliprogramlama

class Araba(var renk: String, var hiz: Int, var calisiyorMu: Boolean) {

    fun calistir(){
        calisiyorMu = true
    }
    fun durdur(){
        hiz = 0
        calisiyorMu = false
    }
    fun hizlan(kacKm:Int){
        calistir()
        hiz += kacKm
    }
    fun yavasla(kacKm:Int){
        if(hiz - kacKm >= 0)
            hiz -= kacKm
        else
            durdur()
    }
    override fun toString(): String {
        return "Araba(renk='$renk', hız=$hiz, çalışıyor mu?=$calisiyorMu)"
    }

}