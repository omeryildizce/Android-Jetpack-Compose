package com.omeryildizce.collections

fun main(){
    val o1  = Ogrenci(1,"Ahmet","11f")
    val o2  = Ogrenci(2,"Zeynep","10r")
    val o3 = Ogrenci(3, "Ceyda", "9z")
    val o4 = Ogrenci(1, "Ayşe", "12a")
    val ogrenciler = HashSet<Ogrenci>()
    ogrenciler.add(o1)
    ogrenciler.add(o2)
    ogrenciler.add(o3)


    for (o in ogrenciler){
        println("********  Öğrenci  ********")
        println(o.toString())
    }
}