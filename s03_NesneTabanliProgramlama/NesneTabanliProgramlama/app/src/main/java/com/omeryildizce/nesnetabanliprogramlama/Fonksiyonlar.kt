package com.omeryildizce.nesnetabanliprogramlama

fun main() {
    selamla()
    selamla("Veli")
    selamla("Ali")
    topla(17,13)
    topla()
    topla(1,2,3,4,5,6,7,8,9,10)
    topla(2,4,5,6)
}

fun topla(sayi1: Int, sayi2: Int) {
    println(sayi1+sayi2)
}

fun topla(vararg sayilar:Int){
    println(sayilar.sum())
}
fun selamla(isim: String) {
    val sonuc = "Merhaba " + isim
    println(sonuc)
}

fun selamla()  {
    val sonuc = "Merhaba Ahmet"
    println(sonuc)
}
