package com.omeryildizce.standartprogramlamayapilari

import kotlin.math.*
import kotlin.random.Random

fun main() {
    for (i in 1..10) {
        val rastgeleSayi = Random.nextInt(0, 10)
        println("$i. Sayı: $rastgeleSayi")

    }

    println("ceil: ${ceil(1.2)}")
    println("floor: ${floor(1.2)}")
    println("sqrt: ${sqrt(4.0)}")
    println("abs: ${abs(-4.0)}")
    println()
    println("min: ${min(10,11)}")
    println("max: ${max(10,11)}")
    println("pow: ${2.0.pow(2)}")


}