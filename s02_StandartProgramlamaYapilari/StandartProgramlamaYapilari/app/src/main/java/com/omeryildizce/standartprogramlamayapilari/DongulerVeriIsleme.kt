package com.omeryildizce.standartprogramlamayapilari

fun main() {

    println("İşlenecek veri miktarini giriniz")
    var veri = readLine()?.toInt()

    if (veri != null) {
        while (veri>0){
            println("$veri. veri")
            veri--
        }
    }
}