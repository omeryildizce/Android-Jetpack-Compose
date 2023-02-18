package com.omeryildizce.nesnetabanliprogramlama2

fun main() {
    val aslan = Aslan()
    val amasyaElması:Elma = AmasyaElması()
    val elma = Elma()
    val tavuk:Eatable = Tavuk()

    val nesneler = arrayOf(aslan,amasyaElması,elma,tavuk)
    for (nesne in nesneler){
        if (nesne is Eatable){
            nesne.howToEat()
        }
        if (nesne is Squeezable){
            nesne.howToSqueeze()
        }

    }
}