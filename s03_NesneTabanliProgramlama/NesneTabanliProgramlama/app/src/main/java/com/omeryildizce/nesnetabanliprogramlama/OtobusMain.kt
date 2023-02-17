package com.omeryildizce.nesnetabanliprogramlama

fun main() {
    val kamilKoc = Otobus(50,"Ankara","İstanbul",25)
    println(kamilKoc.toString())
    kamilKoc.yolcuAl(10)
    println(kamilKoc.toString())
    kamilKoc.yolcuAl(15)
    println(kamilKoc.toString())
    kamilKoc.yolcuAl(1)
    println(kamilKoc.toString())
    kamilKoc.yolcuIndir(40)
    println(kamilKoc.toString())
    kamilKoc.yolcuIndir(20)
    println(kamilKoc.toString())

}