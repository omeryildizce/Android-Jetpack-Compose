package com.omeryildizce.collections

class Urun(var urunNo: Int, var urunAd: String, var urunFiyat: Double) {
    override fun toString(): String {
        return "Ürün No: $urunNo\n" + "Ürün Adı: '$urunAd'\n" + "Ürün Fiyatı: '$urunFiyat'"
    }
}