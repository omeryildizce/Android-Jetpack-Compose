package com.omeryildizce.collections

fun main() {
    val k1 = Kisiler(1, "Ahmet")
    val k2 = Kisiler(2, "Zeynep")
    val k3 = Kisiler(3, "Berna")

    val kisilerArrayList = ArrayList<Kisiler>()
    kisilerArrayList.add(k1)
    kisilerArrayList.add(k2)
    kisilerArrayList.add(k3)

    println("Önce")
    for (k in kisilerArrayList) {
        println("${k.kisiNo} ${k.kisiAd}")

    }
    println("Sayısal küçükten büyüğe")
    val siralamaArrayList1 = kisilerArrayList.sortedWith(compareBy { kisi ->
        kisi.kisiNo

    })

    siralamaArrayList1.forEach { kisi ->
        println("${kisi.kisiNo}: ${kisi.kisiAd}")
    }

    println("Sayısal büyükten küçüğe")
    val siralamaArrayList2 = kisilerArrayList.sortedWith(compareByDescending{ kisi -> kisi.kisiNo})
    for (kisi in siralamaArrayList2)
        println("${kisi.kisiNo}: ${kisi.kisiAd}")

    println("İsim büyükten küçüğe")
    val siralamaArrayList3 = kisilerArrayList.sortedWith(compareByDescending{ kisi -> kisi.kisiAd})
    for (kisi in siralamaArrayList3)
        println("${kisi.kisiNo}: ${kisi.kisiAd}")
}