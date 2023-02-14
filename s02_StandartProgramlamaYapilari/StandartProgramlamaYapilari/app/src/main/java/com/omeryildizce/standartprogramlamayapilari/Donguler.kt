package com.omeryildizce.standartprogramlamayapilari

fun main() {
    for (i in 1..3) {
        println(i)

    }

    var isim = "Ömer YILDIZ"
    for (i in isim.length - 1 downTo 0) {
        print(isim[i])
    }

    val baslangic = 0
    val bitis = 20
    val artisMiktari = 5
    for (i in baslangic..bitis step artisMiktari)
    {
        println("$i ")
    }

    var sayac = 1
    while (sayac < 5){
        println(sayac)
        sayac++
    }
}