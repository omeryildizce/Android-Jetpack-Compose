package com.omeryildizce.nesnetabanliprogramlama2

fun main() {
    val topkapiSarayi = Saray(5,230)
    val bogazVilla = Villa(true, 20)
    println(topkapiSarayi.toString())
    println(bogazVilla.toString())

    var ev = Ev(5)
    ev = topkapiSarayi
    println(ev.toString())

}