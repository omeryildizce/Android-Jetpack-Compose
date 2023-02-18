package com.omeryildizce.collections

fun main() {
    val liste = ArrayList<String>()
    val liste2 :ArrayList<String> = ArrayList<String>()
    val meyveler = ArrayList<String>()
    meyveler.add("Çilek")
    meyveler.add("Muz")
    meyveler.add("Elma")
    meyveler.add("Kivi")
    meyveler.add("Kiraz")
    println(meyveler.toString())
    println(meyveler[4])
    println(meyveler.get(4))
    meyveler.add("Mandalina")
    println(meyveler.toString())
    meyveler[3] ="Kayısı"
    println(meyveler.toString())
    meyveler.add(2,"Portakal")
    println(meyveler.toString())

}