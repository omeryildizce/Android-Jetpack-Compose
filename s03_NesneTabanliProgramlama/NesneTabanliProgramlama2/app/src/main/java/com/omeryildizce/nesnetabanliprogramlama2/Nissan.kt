package com.omeryildizce.nesnetabanliprogramlama2

class Nissan(var model: String, vites: String, renk: String, kasaTipi: String) : Araba(kasaTipi,renk,vites){
    override fun toString(): String {
        return super.toString() + ", model='$model'"
    }
}