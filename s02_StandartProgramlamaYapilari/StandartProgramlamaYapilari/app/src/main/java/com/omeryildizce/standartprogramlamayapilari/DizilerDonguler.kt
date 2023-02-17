package com.omeryildizce.standartprogramlamayapilari

fun main() {
    val meyveler = arrayOf<String>("armut","çilek","elma","kivi", "muz","kiraz")
    for (meyve in meyveler){
        println(meyve.replaceFirstChar { c: Char -> c.titlecase() })
    }
    for ((index, meyve) in meyveler.withIndex()){
        println("$index: $meyve")
    }
}