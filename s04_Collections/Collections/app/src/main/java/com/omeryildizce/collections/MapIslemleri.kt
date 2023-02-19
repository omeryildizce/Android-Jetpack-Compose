package com.omeryildizce.collections

fun main() {
    val sayilar = mapOf<Int, String>(1 to "Bir", 2 to "iki")
    val oranlar = mutableMapOf<Double, String>(1.5 to "Oran 1", 3.4 to "Oran 2")
    val iller = HashMap<Int, String>()
    iller.put(16, "Bursa")
    iller.put(34, "İstanbul")
    println(iller.toString())
    iller.put(16, "Bursaa")
    println(iller.toString())
    println(iller[34])
    println(iller.size)
    println(iller.count())
    println(iller.isEmpty())
    println(iller.containsKey(16))
    println(iller.containsValue("İstanbul"))

    for ((anahtar, deger) in iller){
        println("$anahtar $deger")
    }
    iller.remove(16)
    println(iller.toString())
    iller.clear()
    println(iller.toString())
}