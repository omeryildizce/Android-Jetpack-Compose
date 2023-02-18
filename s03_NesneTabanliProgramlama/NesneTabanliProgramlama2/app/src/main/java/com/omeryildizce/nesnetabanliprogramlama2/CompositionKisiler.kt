package com.omeryildizce.nesnetabanliprogramlama2

fun main() {
    val adres = Adres("Bursa", "Osmangazi")
    val kisi = Kisiler1("Ömer",45, adres)
    println(kisi.toString())
}