package com.omeryildizce.nesnetabanliprogramlama2

fun main() {
    val aslan = Aslan()
    val amasyaElmasÄ±:Elma = AmasyaElmasÄ±()
    val elma = Elma()
    val tavuk:Eatable = Tavuk()

    val nesneler = arrayOf(aslan,amasyaElmasÄ±,elma,tavuk)
    for (nesne in nesneler){
        if (nesne is Eatable){
            nesne.howToEat()
        }
        if (nesne is Squeezable){
            nesne.howToSqueeze()
        }

    }
}