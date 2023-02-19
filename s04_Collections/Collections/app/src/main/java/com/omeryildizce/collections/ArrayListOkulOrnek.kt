package com.omeryildizce.collections

fun main() {
    val ogrenciler = ArrayList<Ogrenci>()
    var sayac = 1
    while (true) {
        println("$sayac. Öğrencinin adı:")
        val ad = readLine().toString()
        println("$sayac. Öğrencinin sınıfı:")
        val sinif = readLine().toString()
        val yeniOgrenci = Ogrenci(sayac, ad, sinif)
        sayac += 1
        ogrenciler.add(yeniOgrenci)
        println("Çıkmak için (q)")
        println("Devam etmek için herhangi biir tusa basınız")
        if (readLine() == "q") {
            println("Çıkış yapıldı")
            break
        }

    }

    println(ogrenciler.toString())
    for (ogrenci in ogrenciler)
        println(ogrenci)
}