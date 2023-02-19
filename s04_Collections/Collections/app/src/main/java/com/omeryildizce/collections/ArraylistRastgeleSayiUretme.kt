package com.omeryildizce.collections

import kotlin.random.Random

fun main() {
    val sayiar = ArrayList<Int>()
    for (i in 1..100){
        val rastgeleSayi = Random.nextInt(0,101)
        sayiar.add(rastgeleSayi)
    }

    println(sayiar.toString())
    println()
    sayiar.sort()
    println(sayiar.toString())
}