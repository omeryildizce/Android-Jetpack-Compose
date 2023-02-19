package com.omeryildizce.collections

fun main() {
    val isimler = ArrayList<String>()
    isimler.add("ahmet")
    isimler.add("mehmet")
    isimler.add("zeynep")
    isimler.add("sedat")
    isimler.add("ercan")

    println("Aratmak için isim giriniz")
    val isim:String = readLine() ?: ""

    for (i in isimler) {
        if (i==isim) {
            println("isim mevcut")
            break
        }
    }
}