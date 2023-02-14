package com.omeryildizce.standartprogramlamayapilari

fun main() {

    println("1: Sil")
    println("2: Ekle")
    val tercih = readLine()?.toInt() ?: 1

    val sonuc = when(tercih){
        1-> "Veri Silindi"
        2-> "Veri Eklendi"
        else -> "Hatalı seçim"
    }
    println(sonuc)
}