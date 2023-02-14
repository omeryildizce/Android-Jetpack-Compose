package com.omeryildizce.standartprogramlamayapilari

fun main() {
    println("1: Toplama")
    println("2: Çıkarma")
    println("3: Çarpma")
    println("4: Bölme")

    val tercih = readLine()?.toInt()
    println("1. Sayı")
    val sayi1: Int = readLine()?.toInt() ?: 1
    println("2. Sayı")
    val sayi2: Int = readLine()?.toInt() ?: 1
    if (tercih == 1) {
        println(sayi1 + sayi2)
    } else if (tercih == 2) {
        println(sayi1 - sayi2)
    } else if (tercih == 3) {
        println(sayi1 * sayi2)
    } else if (tercih == 4) {
        println(sayi1 / sayi2)
    }


}

