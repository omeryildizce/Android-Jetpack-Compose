package com.omeryildizce.collections

fun main() {
    val u1 = Urun(1, "Saat", 150.0)
    val u2 = Urun(2, "TV", 7500.00)
    val u3 = Urun(3, "Pc", 9500.00)

    val urunler: ArrayList<Urun> = ArrayList<Urun>()
    urunler.add(u1)
    urunler.add(u2)
    urunler.add(u3)

    for (urun in urunler){
        repeat(30){ print("*") }
        println()
        println(urun.toString())
    }
}