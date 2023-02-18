package com.omeryildizce.nesnetabanliprogramlama2

fun main() {
    ucretAl(KonserveBoyut.Orta)
}

fun ucretAl(boyut: KonserveBoyut) {
    when(boyut){
        KonserveBoyut.Kucuk -> println(20*30)
        KonserveBoyut.Orta -> println(30*30)
        KonserveBoyut.Buyuk -> println(40*30)

    }
}
