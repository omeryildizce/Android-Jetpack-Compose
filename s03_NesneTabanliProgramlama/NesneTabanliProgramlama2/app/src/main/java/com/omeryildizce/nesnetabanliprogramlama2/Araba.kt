package com.omeryildizce.nesnetabanliprogramlama2

open class Araba(var kasaTipi: String, renk: String, vites: String) : Arac(renk, vites) {

    override fun toString(): String {
        return  super.toString() +" ,kasaTipi='$kasaTipi'"
    }
}