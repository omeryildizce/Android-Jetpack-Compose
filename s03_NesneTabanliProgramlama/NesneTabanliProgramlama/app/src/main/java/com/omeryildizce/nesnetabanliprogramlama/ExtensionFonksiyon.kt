package com.omeryildizce.nesnetabanliprogramlama

fun main() {
    println(5 kere 10)
    println(4.carp(8))
    println(10 kere 7 kere 4)

}

fun Int.carp(sayi:Int) : Int{
    return this * sayi
}

infix fun Int.kere(sayi:Int) : Int{
    return this * sayi
}