package com.omeryildizce.collections

fun main() {
    val sayilar = ArrayList<Int>()
    sayilar.add(1)
    sayilar.add(2)
    sayilar.add(3)
    sayilar.add(4)
    sayilar.add(5)

    for ((index, sayi) in sayilar.withIndex()){
        val sonuc = sayi * 2
        sayilar[index] = sonuc
        println(sayilar[index])
    }
}