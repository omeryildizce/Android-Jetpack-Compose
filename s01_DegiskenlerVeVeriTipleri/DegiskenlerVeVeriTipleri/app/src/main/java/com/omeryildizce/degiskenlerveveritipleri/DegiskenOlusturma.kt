package com.omeryildizce.degiskenlerveveritipleri

fun main() {
    var ogrenciAdi = "Ömer";
    var ogrenciYas = 23;
    var ogrenciBoy = 1.98
    var ogrenciBasHarf = 'Ö'

    println(ogrenciAdi)
    println(ogrenciYas)
    println(ogrenciBoy)
    println(ogrenciBasHarf)

    var urunId : Int = 3416
    var urunAd : String = "Kol saati"
    var urunAdet : Int = 100
    var urunFiyat : Double = 149_000.99
    var urunTedarikci : String = "Rolex"

    println(urunId)
    println(urunAd)
    println(urunAdet)
    println(urunFiyat)
    println(urunTedarikci)

    println("${urunTedarikci} marka $urunAd ${urunFiyat} TL fiyatla satılmaktadır. Stokta $urunAdet adet kalmıştır.")

    var a = 10;
    var b = 20;
    println("$a + $b = ${a + b}")

}