package com.omeryildizce.standartprogramlamayapilari

fun main() {

    println("Kullanıcı Adı")
    val isim = readLine()
    println("Tekrar Sayısı")
    val tekrarSayisi = readLine()?.toInt() ?: 1

    for (i in 1..tekrarSayisi){
        println("$i. $isim")
    }

}