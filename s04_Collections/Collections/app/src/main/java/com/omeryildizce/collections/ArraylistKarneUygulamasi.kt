package com.omeryildizce.collections

fun main() {
    var dersadi:String
    var dersnotu:Int
    var dersNotlariList:ArrayList<DersNotlar> = ArrayList<DersNotlar>()
    while (true) {
        println("Çıkmak için (1) - Devam etmek için diğer sayılar")
        val cikis = readLine()
        if (cikis != "1") {
            println("Ders adı:")
            dersadi = readLine().toString()
            println("Ders notu:")
            dersnotu = readLine()?.toIntOrNull() ?: 0
            val yeniNot = DersNotlar(dersadi, dersnotu)
            dersNotlariList.add(yeniNot)
        } else {
            var toplam = 0
            for (dn in dersNotlariList){
               println("*********** Ders ****************")
                println(dn.toString())
                toplam+= dn.not
            }
            println("*********** Ortalama ****************")
            println("Ortalama: ${toplam / dersNotlariList.size}")
            println()
            println("Çıkış Yapıldı")
            break
        }

    }

}