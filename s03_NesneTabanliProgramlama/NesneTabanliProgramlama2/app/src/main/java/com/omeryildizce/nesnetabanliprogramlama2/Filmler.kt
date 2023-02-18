package com.omeryildizce.nesnetabanliprogramlama2

class Filmler(
    var filmId: Int,
    var filmAd: String,
    var filmYıl: Int,
    var kategori: Kategoriler,
    var yonetmen: Yonetmenler
) {
    override fun toString(): String {
        return "Filmler(filmId=$filmId, filmAd='$filmAd', filmYıl=$filmYıl, kategori=${kategori.kategoriAd}, yonetmen=${yonetmen.yonetmenAd})"
    }
}