package com.omeryildizce.stringyapisi

fun main() {
    println("Kelime giriniz")
    val kelime = readLine().toString()

    for (i in kelime.indices.reversed()){
        println(kelime[i])
    }


}