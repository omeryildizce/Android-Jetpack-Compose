package com.omeryildizce.nesnetabanliprogramlama2

class Saray(var kuleSayisi: Int, pencereSayisi: Int) : Ev(pencereSayisi) {
    override fun toString(): String {
        return "Saray kuleSayisi=$kuleSayisi, " + super.toString()
    }
}