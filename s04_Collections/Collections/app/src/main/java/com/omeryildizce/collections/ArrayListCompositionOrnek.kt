package com.omeryildizce.collections

fun main() {
    val personelListesi = ArrayList<Personel>()
    for (i in 1..5){
        println("$i. Personelin adi:")
        val ad = readLine().toString()
        println("$i. Personelin adres ili:")
        val il = readLine().toString()
        println("$i. Personelin adres ilçesi:")
        val ilce = readLine().toString()

        val adres = Adres(il, ilce)
        val personel = Personel(i,ad, adres)
        personelListesi.add(personel)
    }

    for (personel in personelListesi){
        println(personel.toString())
    }
}