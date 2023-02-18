package com.omeryildizce.nesnetabanliprogramlama2

class Mudur:Personel() {
    fun iseAl(personel: Personel){
        personel.iseAlindi()
    }
    fun terfiEttir(p:Personel){
        if (p is Ogretmen){
            p.maasArttir()
        }
    }
}