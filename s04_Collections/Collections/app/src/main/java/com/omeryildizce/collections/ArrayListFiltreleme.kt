package com.omeryildizce.collections

fun main() {
    val o1 = Ogrenci(1, "Ahmet", "11F")
    val o2 = Ogrenci(2, "Zeynep", "11R")
    val o3 = Ogrenci(3, "Ceyda", "12A")
    val o4 = Ogrenci(4, "Mehmet", "9Z")
    val o5 = Ogrenci(5, "Yasin", "11F")

    val ogrenciler = ArrayList<Ogrenci>()
    ogrenciler.add(o1)
    ogrenciler.add(o2)
    ogrenciler.add(o3)
    ogrenciler.add(o4)
    ogrenciler.add(o5)

    val sonucListe = ogrenciler.filter { ogrenci -> ogrenci.ad.lowercase().contains("a") }
    for(ogrenci in sonucListe){
        println("*****************************")
        println("Öğrenci No:     ${ogrenci.no}")
        println("Öğrenci Ad:     ${ogrenci.ad}")
        println("Öğrenci Sınıfı: ${ogrenci.sinif}")
    }
        println("*****************************")
}