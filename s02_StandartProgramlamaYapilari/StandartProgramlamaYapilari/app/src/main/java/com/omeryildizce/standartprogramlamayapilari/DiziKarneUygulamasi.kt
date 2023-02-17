package com.omeryildizce.standartprogramlamayapilari

import androidx.annotation.IntegerRes

fun main() {
    val dersler = Array<String>(5) { "" }
    val notlar = Array<Int>(5) { 0 }
    for (i in dersler.indices) {
        println("${i + 1}. ders:")
        dersler[i] = readLine().toString()
        println("${i + 1}. ders notu:")
        notlar[i] = readLine()?.toIntOrNull() ?: 0
    }

    var ortalama = notlar.sum() / notlar.count()
    for (i in dersler.indices){
        println("${dersler[i]}: ${notlar[i]}")

    }
    if (ortalama>=50) println("$ortalama ile geçti") else println("${ortalama} ile kaldı")
}