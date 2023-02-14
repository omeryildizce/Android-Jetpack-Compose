package com.omeryildizce.standartprogramlamayapilari

fun main() {

    while (true) {
        println("Sayı giriniz")
        val sayi = readLine()?.toInt() ?: 0
        if (sayi % 2 == 0) println("Çift") else println("Tek")
            println("Çıkmak için -> 1")
        val veri = readLine()
        if (veri == "1") {
            break
        }
    }
}