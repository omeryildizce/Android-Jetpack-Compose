package com.omeryildizce.standartprogramlamayapilari

fun main() {
    val dizi1 = Array<Int>(size = 5){0}
    val dizi2 = arrayOf(1,2,3)
    val dizi3 = arrayOf<Int>(1,2,3)
    val dizi4 = arrayOf<String>("elma","armut","çilek")
    val dizi5 = arrayOf(1,2.3,3.4f,true,false,'c',"String")

    val meyveler = arrayOf<String>("Çilek", "Muz","Elma","Kivi","Kiraz")


    val str1 = meyveler[0]
    println(str1)

    println(meyveler.contentToString())
    meyveler.set(2, "Karpuz")
    println(meyveler.isEmpty())
    println(meyveler.count())
    println(meyveler.first())
    println(meyveler.last())
    println(meyveler.contains("Kivi"))
    println(meyveler.indexOf("kivi"))
    println(meyveler.max())
    println(meyveler.min())
    meyveler.sort()
    println(meyveler.contentToString())
    meyveler.reverse()


}