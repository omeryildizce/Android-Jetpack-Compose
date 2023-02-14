package com.omeryildizce.standartprogramlamayapilari

fun main() {

    println("Dikdörtgen alanı için 1")
    println("Daire alanı için 2")
    val girdi = readLine()?.toInt()

    if (girdi==1){
        println("Kısa kenarı giriniz")
        val kisakenar = readLine()?.toInt() ?:1
        println("Uzun kenarı giriniz")
        val uzunkenar = readLine()?.toInt() ?: 1
        println("Dikdörtgen alanı: ${kisakenar * uzunkenar}")
    }else if(girdi == 2){
        println("Yarıçapı giriniz")
        val r = readLine()?.toInt() ?: 1
        println("Daire alanı: ${r * r * Math.PI}")

    }
}