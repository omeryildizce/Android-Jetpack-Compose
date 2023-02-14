package com.omeryildizce.standartprogramlamayapilari

fun main() {

    for (i in 3..6) {
        println("Döngü 1: $i")
    }

    var sayac = 3
    while (sayac < 7) {
        println("Döngü 2: $sayac")
        sayac++
    }

    for (i in 0..8 step 2){
        println(i)
    }
}