package com.omeryildizce.nesnetabanliprogramlama

fun main() {
    val bmw = Araba("Mavi", 220, true)
    println(bmw.toString())

    bmw.renk = "beyaz"
    bmw.hiz = 125
    bmw.calisiyorMu = true
    println(bmw.toString())
    bmw.durdur()
    println(bmw.toString())
    bmw.calistir()
    println(bmw.toString())
    bmw.hizlan(100)
    println(bmw.toString())
    bmw.yavasla(10)
    println(bmw.toString())



}