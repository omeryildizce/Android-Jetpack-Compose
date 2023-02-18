package com.omeryildizce.nesnetabanliprogramlama2

fun main() {
    val k1 = Kategoriler(1,"Dram")
    val k2 = Kategoriler(2, "Komedi")
    val k3 = Kategoriler(3, "Aksiyon")

    val y1 = Yonetmenler(1,"Nuri Bilge Ceylan")
    val y2 = Yonetmenler(2, "Quentin Tarantino")
    val y3 = Yonetmenler(3, "Steven Spielberg")

    val f1 = Filmler(1, "Django",2013, k1, y1)
    val f2 = Filmler(2, "Dört Oda",1995, k2, y2)
    val f3 = Filmler(3, "Jaws",2008, k3, y3)

    println(f1.toString())
    println(f2.toString())
    println(f3.toString())
}