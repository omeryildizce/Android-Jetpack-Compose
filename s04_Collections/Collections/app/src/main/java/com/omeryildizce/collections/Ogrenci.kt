package com.omeryildizce.collections

class Ogrenci(var no: Int, var ad: String, var sinif: String) {
    override fun hashCode(): Int {
        return this.no
    }

    override fun equals(other: Any?): Boolean {
        if (this.no == (other as Ogrenci).no) {
            return true
        }
        return false
    }

    override fun toString(): String {
        return String.format("Ogrenci no: %4d, Adı: %-15s, Sınıf: %3s", no, ad, sinif)
    }
}