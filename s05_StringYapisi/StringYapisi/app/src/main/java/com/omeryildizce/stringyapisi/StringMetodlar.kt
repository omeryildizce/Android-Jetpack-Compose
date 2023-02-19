package com.omeryildizce.stringyapisi

fun main() {
    val str1 = "Merhaba"
    println(str1.subSequence(1,4))
    println(str1.contains("er"))
    println(str1.lowercase())
    println(str1.uppercase())
    var str12 = str1+" " + "Dünya"
    println(str12.trim().split(" "))

}