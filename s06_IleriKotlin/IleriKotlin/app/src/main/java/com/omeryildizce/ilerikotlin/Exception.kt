package com.omeryildizce.ilerikotlin

fun main() {
    val x = 10
    val y = 0
    val dizi = Array<Int>(2) { 0 }
    try {
        dizi[4] = 8
        println("Sonuç: ${x / y}")
    } catch (e:ArithmeticException) {
        println("Sonuç: ${x}/${y}")
    }catch (e:ArrayIndexOutOfBoundsException) {
        println("Veri yok")
    }


}