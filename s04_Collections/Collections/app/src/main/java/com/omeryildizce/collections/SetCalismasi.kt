package com.omeryildizce.collections

fun main() {
    val meyveler = setOf("çilek","armut","mandalina","muz","karpuz","ayva")
    val  iller = mutableListOf<String>("Kayseri","Karabük","Adana","Giresun","Tekirdağ")
    val sayilar = HashSet<Int>()

    sayilar.add(1)
    sayilar.add(1)
    sayilar.add(1)
    sayilar.add(10)
    sayilar.add(15)
    sayilar.add(2)
    sayilar.add(-12)
    sayilar.add(0)
    sayilar.add(2)
    sayilar.add(-2)
    sayilar.add(3)

    println(meyveler.toString())
    println(sayilar.toString())
    println(sayilar.elementAt(5))
    println(sayilar.count())
    println(sayilar.isEmpty())
    println(sayilar.contains(20))

    for (s in sayilar){
        println(s)
    }

}