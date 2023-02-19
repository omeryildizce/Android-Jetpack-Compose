package com.omeryildizce.collections

fun main() {
    val sayilar = ArrayList<Int>()
    sayilar.add(1)
    sayilar.add(23)
    sayilar.add(32)
    sayilar.add(47)
    sayilar.add(59)
    sayilar.add(100)
    sayilar.add(18)
    sayilar.add(54)
    sayilar.add(27)

    val tekler = ArrayList<Int>()
    val ciftler = ArrayList<Int>()
    for (s in  sayilar){
        if (s%2==0){
            ciftler.add(s)
        }
        else {
            tekler.add(s)
        }
    }
    println("tekler")
    println(tekler.toString())
    println("çiftler")
    println(ciftler.toString())
}